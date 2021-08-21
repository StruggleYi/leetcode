package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:31 2021/8/12
 * description 最长回文子序列
 * node:
 * path: https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * level: medium
 **/
public class Question516 {
    public int longestPalindromeSubseq(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (c[i] == c[j]) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
