package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:12 2021/4/25
 * description 二维数组中的查找
 * node: 从右上角开始找即可
 * path: https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 * level: medium
 **/
public class Question004 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;

        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            int k = matrix[i][j];
            if (k == target) {
                return true;
            } else if (k > target) {
                j--;
            } else {
                i++;
            }
        }

        return false;
    }
}
