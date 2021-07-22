package LeetCode;

/**
 * @author Struggle
 * @date Created in 20:53 2021/5/18
 * description 形成两个异或相等数组的三元组数目  给你一个整数数组 arr   现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。
 *                                          a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
 *                                          b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
 *                                          请返回能够令 a == b 成立的三元组 (i, j , k) 的数目
 * node: 当arr[i]^arr[i+1]^...^arr[k]==0成立时，i可以取到k-i种，循环遍历i与k，累异或即可
 * path: https://leetcode-cn.com/problems/count-triplets-that-can-form-two-arrays-of-equal-xor/
 * level: medium
 **/
public class Question1442 {

    /**
     * 改进思路:
     * a==b,可转化为arr[i]^arr[i+1]^...^arr[k]==0，这样的话i的位置取i+1,i+2,,,k,都能成立，即当arr[i]^arr[i+1]^...^arr[k]==0成立时，i可以取到k-i种，循环遍历i与k，累异或即可
     *
     * @param arr
     * @return
     */
    public int countTriplets(int[] arr) {
        int len = arr.length;

        int count = 0;
        for (int i = 0; i < len; i++) {
            int k = arr[i];
            for (int j = i + 1; j < len; j++) {
                k = k ^ arr[j];
                if (k == 0) {
                    count += j - i;
                }
            }
        }

        return count;
    }

    /**
     * 原始做法, 使用二维数组记录i->j的异或值
     * 遍历寻找满足条件的结果
     *
     * @param arr
     * @return
     */
    public int countTriplets2(int[] arr) {
        int len = arr.length;

        int count = 0;
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = arr[i];
            for (int j = i + 1; j < len; j++) {
                dp[i][j] = dp[i][j - 1] ^ arr[j];
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int num = dp[i][j] ^ arr[j];
                for (int k = j; k < len; k++) {
                    if (num == dp[j][k]) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Question1442 q = new Question1442();
        int[] arr = {7, 11, 12, 9, 5, 2, 7, 17, 22};
        System.out.println(q.countTriplets(arr));
    }
}
