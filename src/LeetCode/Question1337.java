package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Struggle
 * @date Created in 23:12 2021/8/21
 * description 阵中战斗力最弱的 K 行 给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。
 * 请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序
 * node:
 * path: https://leetcode-cn.com/problems/the-k-weakest-rows-in-a-matrix/
 * level: easy
 **/
public class Question1337 {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[][] count = new int[mat.length][2];

        for (int i = 0; i < mat.length; i++) {
            count[i][0] = i;
            for (int j = 0; j < mat[i].length; j++) {
                count[i][1] += mat[i][j];
            }
        }

        Arrays.sort(count, Comparator.comparingInt(o -> o[1]));

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = count[i][0];
        }

        return res;
    }
}
