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
     * 暴力做法, 具体如何剪枝, 后续可以继续思考
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

        // p 匹配完成但是 s 未完成, 无法进行匹配
        if (j == p.length()) {
            return false;
        }

        if (i == s.length()) {

            // 如果s 匹配完成, 但是 p 未完成, 可以考虑后面的子串是否可以表示为空串
            // 如果该位为*, 有两种情况: 1、上一位相等但是不匹配; 2: 上一位只匹配一次, 然后判断后面的子串
            if (p.charAt(j) == '*') {
                return judge(s, p, i - 1, j + 1, flag) || judge(s, p, i, j + 1, flag);
            }

            // 如果子串剩余的个数为奇数, 一定不能表示空串
            if ((p.length() - j) % 2 == 1) {
                return false;
            }

            // 子串剩余的个数为偶数, 只有 x* 或者 .* 的情况才能表示空串
            while (j < p.length()) {
                if (p.charAt(j + 1) == '*') {
                    j += 2;
                } else {
                    return false;
                }
            }

            return true;
        }

        if (flag[i][j] == 1) {
            return false;
        }

        // 两个字母相等的情况
        // p还有下一位时, 如果下一位是*, 有三种情况: 1、这个字母出现0次; 2、这个字母出现1次; 2、这个字母出现多次;
        // 如果下一位是字母或者*, 均只能跳过
        if (s.charAt(i) == p.charAt(j)) {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                return judge(s, p, i + 1, j, flag) || judge(s, p, i, j + 2, flag) || judge(s, p, i + 1, j + 2, flag);
            } else {
                return judge(s, p, i + 1, j + 1, flag);
            }
        } else if (p.charAt(j) == '.') {
            // 两个字母不相等, 且该位是 . , 直接判断下一位
            return judge(s, p, i + 1, j + 1, flag);
        } else if (p.charAt(j) == '*') {
            // 两个字母不相等, 且该位是 * , 由于字母相等时会判断下一位是*的情况, 所以在此处出现*只有一种情况, 上一位是.
            // 由于.* 可以代表任意字母, 并且数目也任意
            // 所以这里可以分三种情况讨论, 上一个. 代表0次意味着s也需要回退一位, 还有就是代表1次和多次的情况
            return judge(s, p, i + 1, j + 1, flag) || judge(s, p, i + 1, j, flag) || judge(s, p, i - 1, j + 1, flag);
        } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // 如果这里字母不相等, 且下一位是*, 可以代表此字母出现0次
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
