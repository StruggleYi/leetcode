package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 16:42 2019/11/1
 * description Rotate Image 给定一个n*n的二维数组, 将其顺时针旋转(不使用另一个二维数组, 在原有的数组上进行操作)
 * note: 先按照对角线进行翻转, 再将矩阵左右翻转即可
 * eg: 1 2 3       1 4 7      7 4 1
 *     4 5 6  ->   2 5 8  ->  8 5 2
 *     7 8 9       3 6 9      9 6 3
 * path: https://leetcode.com/problems/rotate-image/description/
 * level: medium
 **/
public class Question048 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, j, i, j, n - 1 - i);
            }
        }
    }

    public void swap(int[][] matrix, int i, int j, int m, int n) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[m][n];
        matrix[m][n] = temp;
    }

    public static void main(String[] args) {
        Question048 q = new Question048();
        int[][] nums = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        q.rotate(nums);
        for (int[] k : nums) {
            System.out.println(Arrays.toString(k));
        }
    }
}
