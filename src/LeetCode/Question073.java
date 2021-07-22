package LeetCode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 10:03 2019/11/11
 * description Set Matrix Zeroes 给定一个m*n阶矩阵, 如果数字为0, 则将整行和列的数字都置为0, 不使用额外空间
 * path: https://leetcode.com/problems/set-matrix-zeroes/description/
 * level: medium
 **/
public class Question073 {

    /**
     * 此方法使用了m+n的额外空间用来记录哪一行以及哪一列需要置零
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0){
            return;
        }

        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rows = new HashSet<>();
        Set<Integer> cols = new HashSet<>();

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 不使用额外空间解法
     * 第一次遍历, 判断数字是否为0, 如果为零则将每一列的头数字置为0已经每一行的第一个数字置为0
     * matrix[i][j] == 0 -> matrix[i][0] = 0,matrix[0][j] = 0
     * flag 用来判断第一列是否需要全置为0(判断原有第一列中是否包含0)
     * 此方法用第一列 第一行的数字来记录第一种方法所使用的的标志位
     * 时间复杂度o(m*n) 空间复杂度o(1)
     */
    public void setZeroes2(int[][] matrix) {
        boolean flag = false;
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            //判断第一列中是否有0
            if (matrix[i][0] == 0) {
                flag = true;
            }

            for (int j = 1; j < n; j++) {
                //如果为0, 则将列头和行头置为0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //除去第一行第一列, 开始遍历, 将那些需要遍历的位置置为0
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        //判断第一行是否需要全置为0
        if (matrix[0][0] == 0) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }

        //判断第一列是否需要全置为0
        if (flag) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Question073 q = new Question073();
        int[][] nums = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        q.setZeroes2(nums);
        System.out.println(Arrays.deepToString(nums));
    }
}
