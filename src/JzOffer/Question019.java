package JzOffer;

/**
 * @author Struggle
 * @date Created in 23:33 2021/5/15
 * description 正则表达式匹配 '.'表示任意一个字符 '*'表示它前面的字符可以出现任意次
 * node:
 * path: https://leetcode-cn.com/problems/zheng-ze-biao-da-shi-pi-pei-lcof/
 * level: hard
 **/
public class Question019 {

    /**
     * leetcode 借鉴思路
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        char[][] memo = new char[s.length() + 1][p.length() + 1];
        return isr(s.toCharArray(), 0, p.toCharArray(), 0, memo);
    }

    public boolean isr(char[] chars1, int start1, char[] chars2, int start2, char[][] memo) {
        if (start2 == chars2.length) {
            return chars1.length == start1;
        }
        if (memo[start1][start2] != 0) {
            return memo[start1][start2] == 2;
        }

        boolean firstMatch = start1 < chars1.length &&
                (chars1[start1] == chars2[start2] || chars2[start2] == '.');
        boolean res;
        if (start2 + 1 < chars2.length && chars2[start2 + 1] == '*') {
            res = (firstMatch && isr(chars1, start1 + 1, chars2, start2, memo)) ||
                    isr(chars1, start1, chars2, start2 + 2, memo);
        } else {
            res = firstMatch && isr(chars1, start1 + 1, chars2, start2 + 1, memo);
        }

        if (res) {
            memo[start1][start2] = 2;
        } else {
            memo[start1][start2] = 1;
        }
        return res;
    }

    /**
     * 暴力做法
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch(String s, String p) {
        int[][] flag = new int[s.length()][p.length()];
        return judge(s, p, 0, 0, flag);
    }

    private boolean judge(String s, String p, int i, int j, int[][] flag) {
        if (i == s.length() && j == p.length()) {
            return true;
        }

        if (j == p.length()) {
            return false;
        }

        if (i == s.length()) {
            if (p.charAt(j) == '*') {
                return judge(s, p, i - 1, j + 1, flag) || judge(s, p, i, j + 1, flag);
            }

            if ((p.length() - j) % 2 == 1) {
                flag[i][j] = 1;
                return false;
            }

            while (j < p.length()) {
                if (p.charAt(j + 1) == '*') {
                    j += 2;
                } else {
                    flag[i][j] = 1;
                    return false;
                }
            }

            return true;
        }

        if (flag[i][j] == 1) {
            return false;
        }

        if (s.charAt(i) == p.charAt(j)) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                return judge(s, p, i + 1, j, flag) || judge(s, p, i, j + 2, flag) || judge(s, p, i + 1, j + 2, flag);
            } else {
                return judge(s, p, i + 1, j + 1, flag);
            }
        } else if (p.charAt(j) == '.') {
            return judge(s, p, i + 1, j + 1, flag);
        } else if (p.charAt(j) == '*') {
            return judge(s, p, i + 1, j + 1, flag) || judge(s, p, i + 1, j, flag) || judge(s, p, i - 1, j + 1, flag);
        } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            return judge(s, p, i, j + 2, flag);
        }

        flag[i][j] = 1;
        return false;
    }

    public static void main(String[] args) {
        Question019 q = new Question019();
        System.out.println(q.isMatch("", ".*"));
    }
}
