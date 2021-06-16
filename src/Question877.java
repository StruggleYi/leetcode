/**
 * @author Struggle
 * @date Created in 21:49 2021/6/16
 * description 石子游戏 给定偶数堆石子, A 和 B 每次从两端取走一堆石子, 最后计算A 与 B 各自所拥有的石子数, 若 A 多 返回 true, 否则返回 false
 * node:
 * path: https://leetcode-cn.com/problems/stone-game/
 * level: medium
 **/
public class Question877 {

    /**
     * 数学方法, 先手必胜, 比较有意思
     * 思路参考： https://leetcode-cn.com/problems/stone-game/solution/shi-zi-you-xi-by-leetcode-solution/
     */
    public boolean stoneGame(int[] piles) {
        return true;
    }

    /**
     * dp 记录 i->j 石头堆先拿最多能拿多少石子
     *
     * @param piles
     * @return
     */
    public boolean stoneGame2(int[] piles) {
        int n = piles.length;

        int[][] dp = new int[n + 1][n + 1];
        int count = count(piles, 0, n - 1, dp);

        int sum = 0;
        for (int k : piles) {
            sum += k;
        }

        return count > sum - count;
    }

    private int count(int[] piles, int i, int j, int[][] dp) {
        if (i > j) {
            return 0;
        }

        if (i == j + 1) {
            return Math.max(piles[i], piles[j]);
        }

        int res = 0;
        // 先拿左边第一个, 后拿左边第二个
        if (dp[i + 2][j] == 0) {
            dp[i + 2][j] = count(piles, i + 2, j, dp);
        }
        res = Math.max(res, dp[i + 2][j] + piles[i]);

        // 先拿左边第一个, 后拿右边第一个
        if (dp[i + 1][j - 1] == 0) {
            dp[i + 1][j - 1] = count(piles, i + 1, j - 1, dp);
        }
        res = Math.max(res, dp[i + 1][j - 1] + piles[i]);

        // 先拿右边第一个, 后拿左边第一个
        res = Math.max(res, dp[i + 1][j - 1] + piles[j]);

        // 先拿右边第一个, 后拿右边第二个
        if (dp[i][j - 2] == 0) {
            dp[i][j - 2] = count(piles, i + 1, j - 1, dp);
        }
        res = Math.max(res, dp[i][j - 2] + piles[j]);

        return res;
    }

    public static void main(String[] args) {
        Question877 q = new Question877();
        int[] piles = {5, 3, 4, 5};
        System.out.println(q.stoneGame(piles));
    }
}
