package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:30 2021/5/12
 * description 子数组异或查询 有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。
 * node: 直接使用二维数组会超过内存限制
 * path: https://leetcode-cn.com/problems/xor-queries-of-a-subarray/
 * level: medium
 **/
public class Question1310 {

    /**
     * 由于二维数组会超出内存限制, 所以只能记录部分值
     * 可以从左往右依次记录 arr[0], arr[0]^arr[1], ... , arr[0]^arr[1]^...^arr[n-1] 的值
     * 那么所求的 i 到 j 的异或即可为 (arr[0]^arr[1]^...^arr[j]) ^ (arr[0]^arr[1]^...^arr[i - 1])
     *
     * @param arr
     * @param queries
     * @return
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length;
        int[] xor = new int[n];

        xor[0] = arr[0];
        for (int i = 1; i < n; i++) {
            xor[i] = xor[i - 1] ^ arr[i];
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = xor[queries[i][1]];
            if (queries[i][0] > 0) {
                res[i] ^= xor[queries[i][0] - 1];
            }

        }

        return res;
    }

    public static void main(String[] args) {
        Question1310 q = new Question1310();
        int[] arr = {1, 3, 4, 8};
        int[][] queries = {{0, 1}, {1, 2}, {0, 3}, {3, 3}};
        System.out.println(Arrays.toString(q.xorQueries(arr, queries)));
    }
}
