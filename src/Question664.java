/**
 * @author Struggle
 * @date Created in 21:27 2021/5/24
 * description 奇怪的打印机   1、打印机每次只能打印由 同一个字符 组成的序列 2、每次可以在任意起始和结束位置打印新字符，并且会覆盖掉原来已有的字符
 *                          给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数
 * node:
 * path: https://leetcode-cn.com/problems/strange-printer/
 * level: hard
 **/
public class Question664 {


    /**
     * dp 记录字符串第 i 个字符到第 j 个字符需要操作的次数
     * 若s[i] == s[j], 那么可以假设打印字符串 i->j-1 时可以同时打印第 j 个字符
     * 若s[i] != s[j], 那么整个字符串需要分为两段来进行打印, 取分割点中值相加最小的两段
     * @param s
     * @return
     */
    public int strangePrinter(String s) {

        int n = s.length();
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }

                int min = 100;
                for (int k = i; k < j; k++) {
                    min = Math.min(dp[i][k] + dp[k + 1][j], min);
                }
                dp[i][j] = min;
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        Question664 q = new Question664();
        System.out.println(q.strangePrinter("aba"));
    }
}
