package questionAfter1000;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 20:03 2021/1/18
 * description Matrix Block Sum 给定一个 m*n 的矩阵以及一个K 值, 输出一个矩阵 m*n 矩阵, 其中新矩阵中的第i,j位置上的值为旧矩阵上离i,j位置的距离小于K范围内的值之和
 * node:
 * path: https://leetcode.com/problems/matrix-block-sum/
 * level: medium
 **/
public class Question1314 {

    /**
     * 首次解法, 需要遍历两次数组, 第一次计算每个数在每行中与之相隔距离为k的和, 存储在数组count中
     * 第二次计算题目需要的结果，新矩阵中每个位置的值为纵向与之相隔距离为k的数组count中对应位置的值之和
     * 相当于在行层面上先计算好每行距离为K的值, 最后纵向相加即可
     *
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length;
        int n = mat[0].length;

        int[][] res = new int[m][n];

        // 提前计算好每个点在每行中距离为k的值之和
        int[][] count = new int[m][n];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            int z = 0;
            while (z <= K && z < n) {
                sum += mat[i][z++];
            }
            count[i][0] = sum;
            for (int j = 1; j < n; j++) {
                if (j - K > 0) {
                    sum -= mat[i][j - K - 1];
                }
                if (j + K < n) {
                    sum += mat[i][j + K];
                }
                count[i][j] = sum;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int z = i - K;
                while (z <= i + K && z < m) {
                    if (z < 0) {
                        z++;
                        continue;
                    }
                    res[i][j] += count[z++][j];
                }
            }
        }

        return res;
    }

    /**
     * leetcode 解法
     *  解法很类似, 本方法采取的是先计算每列前k个值之和，不计算所有的值, 然后动态维护该值即可
     * @param mat
     * @param K
     * @return
     */
    public int[][] matrixBlockSum2(int[][] mat, int K) {
        int n = mat.length, m = mat[0].length;
        int[][] res = new int[n][m];
        int[] arr = new int[m];
        for (int i = 0; i <= K && i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[j] += mat[i][j];
            }
        }
        for (int i = 0; i < n; ) {
            int sum = 0;
            for (int j = 0; j <= K && j < m; j++) {
                sum += arr[j];
            }
            for (int j = 0; j < m; ) {
                res[i][j++] = sum;
                if (j - K - 1 >= 0) {
                    sum -= arr[j - K - 1];
                }
                if (j + K < m) {
                    sum += arr[j + K];
                }
            }
            i++;
            if (i - K - 1 >= 0) {
                for (int j = 0; j < m; j++) {
                    arr[j] -= mat[i - K - 1][j];
                }
            }
            if (i + K < n) {
                for (int j = 0; j < m; j++) {
                    arr[j] += mat[i + K][j];
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        Question1314 q = new Question1314();

        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.deepToString(q.matrixBlockSum(mat, 2)));
    }
}
