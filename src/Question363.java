/**
 * @author Struggle
 * @date Created in 23:26 2021/4/22
 * description 矩形区域不超过 K 的最大数值和
 * node: 通过固定左边界, 累计计算右边界的值, 矩形的和变换成行和的数组, 通过判断数组中最大连续和的值来求得不超过k的最大值
 * path: https://leetcode.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * https://leetcode-cn.com/problems/max-sum-of-rectangle-no-larger-than-k/
 * level: hard
 **/
public class Question363 {

    /**
     * leetCode 借鉴思路
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        // O(cols ^ 2 * rows)
        // 枚举左边界
        for (int l = 0; l < cols; l++) {
            // 左边界改变才算区域的重新开始
            int[] rowSum = new int[rows];
            // 枚举右边界
            for (int r = l; r < cols; r++) {
                // 按每一行累计到 dp
                for (int i = 0; i < rows; i++) {
                    rowSum[i] += matrix[i][r];
                }
                // dpmax求最大连续子串和不超过k的最大值
                max = Math.max(max, dpmax(rowSum, k));
                // 尽量提前
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

    /**
     * 在数组 arr 中，求不超过 k 的最大值
     *
     * @param arr
     * @param k
     * @return
     */
    private int dpmax(int[] arr, int k) {
        int rollSum = arr[0], rollMax = rollSum;
        // O(rows)
        for (int i = 1; i < arr.length; i++) {
            if (rollSum > 0) rollSum += arr[i];
            else rollSum = arr[i];
            if (rollSum > rollMax) rollMax = rollSum;
        }
        if (rollMax <= k) return rollMax;
        // O(rows ^ 2)
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < arr.length; l++) {
            int sum = 0;
            for (int r = l; r < arr.length; r++) {
                sum += arr[r];
                if (sum > max && sum <= k) {
                    max = sum;
                }
                // 尽量提前
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }


    /**
     * 原始思路, 暴力破解
     *
     * @param matrix
     * @param k
     * @return
     */
    public int maxSumSubmatrix2(int[][] matrix, int k) {
        int rows = matrix.length, cols = matrix[0].length, max = Integer.MIN_VALUE;
        for (int i1 = 1; i1 <= rows; i1++) {
            for (int j1 = 1; j1 <= cols; j1++) {
                // renew  // from (i1,j1) to (i2,j2)
                int[][] dp = new int[rows + 1][cols + 1];
                dp[i1][j1] = matrix[i1 - 1][j1 - 1];
                for (int i2 = i1; i2 <= rows; i2++) {
                    for (int j2 = j1; j2 <= cols; j2++) {
                        dp[i2][j2] = dp[i2 - 1][j2] + dp[i2][j2 - 1] - dp[i2 - 1][j2 - 1] + matrix[i2 - 1][j2 - 1];
                        if (dp[i2][j2] <= k && dp[i2][j2] > max) max = dp[i2][j2];
                    }
                }
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Question363 q = new Question363();
        int[][] arr = {{1, 0, 1}, {0, -2, 3}};
        System.out.println(q.maxSumSubmatrix(arr, 2));
    }
}
