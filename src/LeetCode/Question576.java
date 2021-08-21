package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:35 2021/8/15
 * description 出界的路径数 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球
 * node:
 * path: https://leetcode-cn.com/problems/out-of-boundary-paths/
 * level: medium
 **/
public class Question576 {
    long[][][] dp = new long[50][50][51];

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        count(m, n, maxMove, startRow, startColumn);
        return (int) (dp[startRow][startColumn][maxMove] % 1000000007);
    }

    private long count(int m, int n, int maxMove, int startRow, int startColumn) {
        if (startRow < 0 || startColumn < 0 || startRow >= m || startColumn >= n) {
            return 1;
        }

        if (maxMove < 0 || (maxMove < startRow + 1 && maxMove < startColumn + 1 && maxMove < m - startRow && maxMove < n - startColumn)) {
            return 0;
        }

        if (dp[startRow][startColumn][maxMove] > 0) {
            return dp[startRow][startColumn][maxMove];
        }

        long count = 0;
        // 上移一格
        count = (count + count(m, n, maxMove - 1, startRow - 1, startColumn)) % 1000000007;

        // 下移一格
        count = (count + count(m, n, maxMove - 1, startRow + 1, startColumn)) % 1000000007;

        // 左移一格
        count = (count + count(m, n, maxMove - 1, startRow, startColumn - 1)) % 1000000007;

        // 右移一格
        count = (count + count(m, n, maxMove - 1, startRow, startColumn + 1)) % 1000000007;

        dp[startRow][startColumn][maxMove] = count;
        return count;
    }
}
