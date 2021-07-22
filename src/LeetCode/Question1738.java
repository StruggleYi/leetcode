package LeetCode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Struggle
 * @date Created in 20:25 2021/5/19
 * description 找出第 K 大的异或坐标值  矩阵中坐标 (a, b) 的 值 可由对所有满足 0 <= i <= a < m 且 0 <= j <= b < n 的元素 matrix[i][j]（下标从 0 开始计数）执行异或运算得到
 * 请你找出 matrix 的所有坐标中第 k 大的值（k 的值从 1 开始计数）
 * node:
 * path: https://leetcode-cn.com/problems/find-kth-largest-xor-coordinate-value/
 * level: medium
 **/
public class Question1738 {

    /**
     * 用大根堆记录第k大的值
     *
     * @param matrix
     * @param k
     * @return
     */
    public int kthLargestValue(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        PriorityQueue<Integer> q = new PriorityQueue<>(k, Comparator.comparingInt(a -> a));

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = dp[i][j - 1] ^ dp[i - 1][j - 1] ^ dp[i - 1][j] ^ matrix[i - 1][j - 1];

                if (q.size() < k) {
                    q.add(dp[i][j]);
                } else {
                    if (q.peek() < dp[i][j]) {
                        q.poll();
                        q.add(dp[i][j]);
                    }
                }
            }
        }

        return q.peek();
    }

    public static void main(String[] args) {
        Question1738 q = new Question1738();
        int[][] matrix = {{5, 2}, {1, 6}};
        System.out.println(q.kthLargestValue(matrix, 1));
    }
}
