package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:00 2021/6/11
 * description 完全平方数  给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少
 * node:
 * path: https://leetcode-cn.com/problems/perfect-squares/
 * level: medium
 **/
public class Question279 {

    /**
     * 数学方法
     * 题解参考：https://leetcode-cn.com/problems/perfect-squares/solution/wan-quan-ping-fang-shu-by-leetcode-solut-t99c/
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        if (isPerfectSquare(n)) {
            return 1;
        }
        if (checkAnswer4(n)) {
            return 4;
        }
        for (int i = 1; i * i <= n; i++) {
            int j = n - i * i;
            if (isPerfectSquare(j)) {
                return 2;
            }
        }
        return 3;
    }

    /**
     * 判断是否为完全平方数
     *
     * @param x
     * @return
     */
    public boolean isPerfectSquare(int x) {
        int y = (int) Math.sqrt(x);
        return y * y == x;
    }

    /**
     * 判断是否能表示为 4^k*(8m+7)
     *
     * @param x
     * @return
     */
    public boolean checkAnswer4(int x) {
        while (x % 4 == 0) {
            x /= 4;
        }
        return x % 8 == 7;
    }

    /**
     * 传统动态规划
     *
     * @param n
     * @return
     */
    public int numSquares2(int n) {

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int k = (int) Math.sqrt(i);

            if (k * k == i) {
                dp[i] = 1;
                continue;
            }

            dp[i] = dp[i - k * k] + 1;
            while (--k >= 1) {
                dp[i] = Math.min(dp[i], dp[i - k * k] + 1);
            }
        }

        return dp[n];
    }
}
