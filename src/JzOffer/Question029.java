package JzOffer;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 1:33 2021/6/6
 * description 顺时针打印矩阵
 * node: 回形打印矩阵中的内容
 * path: https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/
 * level: easy
 **/
public class Question029 {

    /**
     * 思路：
     * 定义四个方向上下左右，从左至右开始遍历，走到不能走为止(碰到左右边界)。
     * 跳出循环的条件：index=数组元素个数
     */
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        // 定义四个边界：上下左右（即已经走过或不能走的位置）
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        //数组元素个数
        int[] res = new int[matrix.length * matrix[0].length];
        //index指向当前遍历的元素
        int index = 0;
        while (index < res.length) {
            //从左至右遍历
            for (int i = left; i <= right; i++) {
                res[index++] = matrix[up][i];
            }
            if (++up > down) {
                break; //++up代表已走过，判断条件代表不能超出边界
            }

            //从上至下遍历
            for (int i = up; i <= down; i++) {
                res[index++] = matrix[i][right];
            }
            if (--right < left) {
                break;
            }

            //从右至左遍历
            for (int i = right; i >= left; i--) {
                res[index++] = matrix[down][i];
            }
            if (--down < up){
                break;
            }

            //从下至上遍历
            for (int i = down; i >= up; i--) {
                res[index++] = matrix[i][left];
            }
            if (++left > right) {
                break;
            }
        }
        return res;
    }


    /**
     * 通过遍历路径, 记录走过的位置的方式
     *
     * @param matrix
     * @return
     */
    public int[] spiralOrder2(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }

        int m = matrix.length;
        int n = matrix[0].length;

        int[] res = new int[m * n];

        int f = 0;
        int k = 0;
        int i = 0, j = 0;

        boolean[][] flag = new boolean[m][n];
        while (k < m * n) {
            if (!flag[i][j]) {
                res[k++] = matrix[i][j];
                flag[i][j] = true;
            }

            if (f % 4 == 0) {
                if (j + 1 == n || flag[i][j + 1]) {
                    f++;
                } else {
                    j++;
                }
            } else if (f % 4 == 1) {
                if (i + 1 == m || flag[i + 1][j]) {
                    f++;
                } else {
                    i++;
                }
            } else if (f % 4 == 2) {
                if (j - 1 < 0 || flag[i][j - 1]) {
                    f++;
                } else {
                    j--;
                }
            } else {
                if (i - 1 < 0 || flag[i - 1][j]) {
                    f++;
                } else {
                    i--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question029 q = new Question029();
        int[][] matrix = {};
        System.out.println(Arrays.toString(q.spiralOrder(matrix)));
    }
}
