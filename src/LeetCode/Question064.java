package LeetCode;

/**
 * @author Struggle
 * @date Created in 12:52 2021/3/27
 * description Minimum Path Sum 给定一个m * n阶矩阵, 求得从矩阵左上方到右下方经过路径最小的值
 * node: 依次计算每个点的最小值, 第i,j个位置上的点的最小值就是左边或者上边的最小值加上自身所得
 * path: https://leetcode.com/problems/minimum-path-sum/
 * level: medium
 **/
public class Question064 {

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] path = new int[m][n];
        path[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            path[0][i] = path[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            path[i][0] = path[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                path[i][j] = Math.min(path[i - 1][j], path[i][j - 1]) + grid[i][j];
            }
        }

        return path[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Question064 q = new Question064();

        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(q.minPathSum(grid));
    }
}
