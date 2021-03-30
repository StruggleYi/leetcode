import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 21:16 2021/3/29
 * description Spiral Matrix 回形输出矩阵的值
 * node: 记录好转的方向和已经走过的点就好
 * path: https://leetcode.com/problems/spiral-matrix/
 * level: medium
 **/
public class Question054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        res.add(matrix[0][0]);

        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] flag = new int[m][n];
        flag[0][0] = 1;

        int k = 1;
        int i = 0, j = 0;
        while (k < m * n) {
            // 余数0, 1, 2, 3分别代表右、下、左、上 运动方向
            int r = count % 4;
            if (r == 0) {
                if (j + 1 < n && flag[i][j + 1] == 0) {
                    res.add(matrix[i][++j]);
                    k++;
                } else {
                    count++;
                }

            } else if (r == 1) {
                if (i + 1 < m && flag[i + 1][j] == 0) {
                    res.add(matrix[++i][j]);
                    k++;
                } else {
                    count++;
                }

            } else if (r == 2) {
                if (j - 1 >= 0 && flag[i][j - 1] == 0) {
                    res.add(matrix[i][--j]);
                    k++;
                } else {
                    count++;
                }

            } else {
                if (i - 1 >= 0 && flag[i - 1][j] == 0) {
                    res.add(matrix[--i][j]);
                    k++;
                } else {
                    count++;
                }
            }
            flag[i][j] = 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Question054 q = new Question054();

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(q.spiralOrder(matrix));
    }
}
