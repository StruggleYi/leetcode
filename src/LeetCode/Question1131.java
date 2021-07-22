package LeetCode;

/**
 * @author Struggle
 * @date Created in 16:09 2021/3/28
 * description Maximum of Absolute Value Expression 给定两个等长的整形数组, 求得|arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|的最大值
 * node: 暴力解法会超时, 采用数学思维将算式进行拆分
 * path: https://leetcode.com/problems/maximum-of-absolute-value-expression/
 * level: medium
 **/
public class Question1131 {


    /**
     * leetcode 借鉴思路
     * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
     *      = max(arr1[i] - arr1[j], arr1[j] - arr1[i]) + max(arr2[i] - arr2[j], arr2[j]-arr2[j]) + max(i-j, j-i)
     *      = max{
     * 		    (arr1[i] + arr2[i] + i) - (arr1[j] + arr2[j] + j) //式1
     * 		    (arr1[i] + arr2[i] - i) - (arr1[j] + arr2[j] - j) //式2
     * 		    (arr1[i] - arr2[i] + i) - (arr1[j] - arr2[j] + j) //式3
     * 		    (arr1[i] - arr2[i] - i) - (arr1[j] - arr2[j] - j) //式4
     * 		    -(arr1[i] + arr2[i] + i) + (arr1[j] + arr2[j] + j)//式5
     * 		    -(arr1[i] + arr2[i] - i) + (arr1[j] + arr2[j] - j)//式6
     * 		    -(arr1[i] - arr2[i] + i) + (arr1[j] - arr2[j] + j)//式7
     * 		    -(arr1[i] - arr2[i] - i) + (arr1[j] - arr2[j] - j)//式8
     *          }
     * 设：
     *  A = arr1[i] + arr2[i] + i
     *  B = arr1[i] + arr2[i] - i
     *  C = arr1[i] - arr2[i] + i
     *  D = arr1[i] - arr2[i] - i
     * |arr1[i] - arr1[j]| + |arr2[i] - arr2[j]| + |i - j|
     *  = max(
     * 		max(A) - min(A),
     * 		max(B) - min(B),
     * 		max(C) - min(C),
     * 		max(D) - min(D),
     * 		-min(A) + max(A),
     * 		-min(B) + max(B),
     * 		-min(C) + max(C),
     * 		-min(C) + max(C)
     * 	   )
     *  所以本题要求的最大值为 最大的A(B,C,D)与最小值的差值
     * @param arr1
     * @param arr2
     * @return
     */
    public int maxAbsValExpr(int[] arr1, int[] arr2) {
        int res = 0;
        int len = arr1.length;

        int[][] f = new int[][]{{1, 1, 1}, {1, -1, 1}, {1, -1, -1}, {1, 1, -1}};

        for (int k = 0; k < 4; k++) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < len; i++) {
                max = Math.max(max, arr1[i] * f[k][0] + arr2[i] * f[k][1] + i * f[k][2]);
                min = Math.min(min, arr1[i] * f[k][0] + arr2[i] * f[k][1] + i * f[k][2]);
            }
            res = Math.max(res, max - min);
        }

        return res;
    }

    public static void main(String[] args) {
        Question1131 q = new Question1131();
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {-1, 4, 5, 6};

        System.out.println(q.maxAbsValExpr(arr1, arr2));
    }
}
