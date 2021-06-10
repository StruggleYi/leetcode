/**
 * @author Struggle
 * @date Created in 22:14 2021/6/10
 * description 零钱兑换 II  给定不同面额的硬币和一个总金额。写出函数来计算可以凑成总金额的硬币组合数 每种面额的硬币数量不限
 * node:
 * path: https://leetcode-cn.com/problems/coin-change-2/
 * level: medium
 **/
public class Question518 {

    /**
     * 一维动态规划思路, 取消物品的概念, 在每次新增一种物品时, 对应能够取到金额为i的方案数在同步增多
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[] f = new int[amount + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            int val = coins[i - 1];
            for (int j = val; j <= amount; j++) {
                f[j] += f[j - val];
            }
        }
        return f[amount];
    }


    /**
     * 动态规划思想, dp[i][j] 代表只使用前i种硬币组成金额为j的组合数
     * 简洁写法, 这里没有进行剪枝
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change2(int amount, int[] coins) {

        int len = coins.length;
        int[][] dp = new int[len + 1][amount + 1];
        dp[0][0] = 1;

        for (int i = 1; i <= len; i++) {
            int coin = coins[i - 1];
            for (int j = 0; j <= amount; j++) {
                // 不使用第j个硬币
                dp[i][j] = dp[i - 1][j];

                // 可以选择多个第j个硬币
                for (int k = 1; k * coin <= j; k++) {
                    dp[i][j] += dp[i - 1][j - k * coin];
                }
            }
        }

        return dp[len][amount];
    }

    /**
     * 第一次ac的解题答案
     *
     * @param amount
     * @param coins
     * @return
     */
    public int change3(int amount, int[] coins) {
        if (amount == 0) {
            return 1;
        }

        // 没有硬币可以选择
        if (amount < coins[0]) {
            return 0;
        }

        int len = coins.length;
        int[][] dp = new int[len][amount + 1];

        // 不管到第几种硬币, 组合金额为0的方案默认为1种, 便是啥都不选择
        for (int i = 0; i < len; i++) {
            dp[i][0] = 1;
        }

        // 初始化第一种硬币能组成值为i的情况
        for (int i = 1; i <= amount; i++) {
            dp[0][i] = i % coins[0] == 0 ? 1 : 0;
        }

        // 从第二种硬币开始遍历
        for (int i = 1; i < len; i++) {
            int coin = coins[i];

            // 如果当前的硬币额度大于总金额, 那么后面都不用进行遍历了
            if (coin > amount) {
                dp[i][amount] = dp[i - 1][amount];
                continue;
            }

            // 不使用当前硬币的情况
            for (int j = 1; j < coin; j++) {
                dp[i][j] = dp[i - 1][j];
            }

            // 当总金额大于当前硬币时, 可以使用该硬币
            for (int j = coin; j <= amount; j++) {
                int k = j;
                dp[i][j] = dp[i - 1][j];

                // 使用1到多个的情况
                while (k - coin >= 0) {
                    dp[i][j] += dp[i - 1][k - coin];
                    k -= coin;
                }
            }
        }

        return dp[len - 1][amount];
    }

    public static void main(String[] args) {
        Question518 q = new Question518();
        int[] coins = {1, 2, 5};
        System.out.println(q.change(5, coins));
    }
}
