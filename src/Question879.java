/**
 * @author Struggle
 * @date Created in 22:43 2021/6/9
 * description 盈利计划  集团里有 n 名员工，他们可以完成各种各样的工作创造利润  第 i 种工作会产生 profit[i] 的利润，它要求 group[i] 名成员共同参与
 * 工作的任何至少产生 minProfit 利润的子集称为 盈利计划 。并且工作的成员总数最多为 n  求有多少种计划可以选择
 * node:
 * path: https://leetcode-cn.com/problems/profitable-schemes/
 * level: hard
 **/
public class Question879 {

    static final int Mod = 1000_000_007;

    /**
     * LeetCode 参考解法 时间比较快，有一部分剪枝操作
     * @param G 人数
     * @param P 最小利润
     * @param groups
     * @param profits
     * @return
     */
    public int profitableSchemes(int G, int P, int[] groups, int[] profits) {
        int n = groups.length;
        int[][] counts = new int[G + 1][P + 1];
        for(int i = 0; i <= G; i++) {
            counts[i][0] = 1;
        }
        for(int i = 0; i < n; i++) {
            int group = groups[i], profit = profits[i];

            // 只算当前能够完成该工作的情况
            for(int j = G; j >= group; j--) {
                long count = counts[j][P];
                for(int k = Math.max(0, P - profit); k <= P; k++) {
                    count += counts[j - group][k];
                }
                counts[j][P] = (int)(count % Mod);
                for(int k = P - 1; k >= profit; k--) {
                    counts[j][k] = (counts[j][k] + counts[j - group][k - profit]) % Mod;
                }
            }
        }
        return counts[G][P];
    }


    /**
     * 常规动态规划做法
     * @param n
     * @param minProfit
     * @param group
     * @param profit
     * @return
     */
    public int profitableSchemes2(int n, int minProfit, int[] group, int[] profit) {
        int len = group.length;

        // dp 用来记录 第i个工作, 不超过j个工人, 产生不少于k的利润的方案数
        long[][][] dp = new long[len + 1][n + 1][minProfit + 1];

        // 如果需要的利润为0, 那么不要员工去做也是一种方案
        for (int i = 0; i <= n; i++) {
            dp[0][i][0] = 1;
        }

        for (int i = 1; i <= len; i++) {

            // a 当前工作需要的人数  b 当前工作能产生的利润
            int a = group[i - 1], b = profit[i - 1];
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {

                    dp[i][j][k] = dp[i - 1][j][k];
                    // 如果当前的人数能够完成此工作
                    if (j >= a) {

                        // 当前工作的利润是否大于此时需要完成的利润
                        // 如果直接都能超过的话, 取0即可, 否则还需要花费工人完成剩下不足的利润
                        int u = Math.max(k - b, 0);
                        dp[i][j][k] += dp[i - 1][j - a][u];

                        // 此题的答案可能很大, 要求返回结果模 10^9 + 7 的值
                        int mod = (int) 1e9 + 7;
                        if (dp[i][j][k] >= mod) {
                            dp[i][j][k] -= mod;
                        }
                    }
                }
            }
        }

        return (int) dp[len][n][minProfit];
    }


    public static void main(String[] args) {
        Question879 q = new Question879();
        int[] group = {2, 3, 5};
        int[] profit = {6, 7, 8};
        System.out.println(q.profitableSchemes(10, 5, group, profit));
    }
}
