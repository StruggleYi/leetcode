package LCP;

/**
 * @author Struggle
 * @date Created in 22:42 2021/7/1
 * description 传递信息
 * node:
 * path: https://leetcode-cn.com/problems/chuan-di-xin-xi/
 * level: easy
 **/
public class Question007 {
    public int numWays(int n, int[][] relation, int k) {
        int[][] pos = new int[n][n];
        int[][] dp = new int[n][k + 1];

        for (int i = 0; i < relation.length; i++) {
            pos[relation[i][0]][relation[i][1]] = 1;
        }

        return count(n - 1, k, pos, dp);
    }

    public int count(int n, int k, int[][] pos, int[][] dp) {
        if (dp[n][k] > 0) {
            return dp[n][k];
        }

        if (k == 1) {
            return pos[0][n];
        }

        int sum = 0;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i][n] == 1) {
                sum += count(i, k - 1, pos, dp);
            }
        }

        dp[n][k] = sum;
        return sum;
    }
}
