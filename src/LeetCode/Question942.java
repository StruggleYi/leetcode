package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:39 2022/5/9
 * description 增减字符串匹配
 * node: 双指针记录使用过的数字即可
 * path: https://leetcode.cn/problems/di-string-match/
 * level: easy
 **/
public class Question942 {
    public int[] diStringMatch(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int i = 0, j = n;
        int[] res = new int[n + 1];
        for (int k = 0; k < n; k++) {
            // I 时取小, D 时取大即可
            if (chars[k] == 'I') {
                res[k] = i;
                i++;
            } else {
                res[k] = j;
                j--;
            }
        }
        res[n] = i;
        return res;
    }
}
