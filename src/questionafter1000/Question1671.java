package questionAfter1000;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 20:20 2021/1/25
 * description Minimum Number of Removals to Make Mountain Array 给定一个数组, 求最少抽出多少个数字能试数组的数字满足山峰型
 * node: 注意, 最后组成的山峰不能为单增或者单减序列, 山顶左右必须有点存在
 * path: https://leetcode.com/problems/minimum-number-of-removals-to-make-mountain-array/
 * level: hard
 **/
public class Question1671 {

    /**
     * 选定封顶的位置k, 求子串单增和单减的最长子串的长度
     * 随后总数相减, 即为最小抽出的数字个数
     *
     * @param nums
     * @return
     */
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        // 存储从0到第k个数字时，最长递增子串的长度
        int[] left = new int[n];
        // 存储从i到最后一个数字时，最长递减子串的长度
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        // 计算最长递增子串的长度
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && left[i] < left[j] + 1) {
                    left[i] = left[j] + 1;
                }
            }
        }

        // 计算最长递减子串的长度
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[j] < nums[i] && right[i] < right[j] + 1) {
                    right[i] = right[j] + 1;
                }
            }
        }

        // 循环选取封顶的位置k, 计算最少个数值
        int max = 0;
        for (int i = 1; i < n - 1; i++) {
            // 如果第k个点能够当做峰顶的值, 子序列个数需要大于1
            if (right[i] > 1 && left[i] > 1) {
                max = Math.max(max, left[i] + right[i] - 1);
            }

        }

        // 总数减去最大个数即为抽离最小个数值
        return n - max;
    }


    public static void main(String[] args) {
        Question1671 q = new Question1671();
        int[] nums = {1, 2, 3, 4, 5, 1000, 999, 998, 997, 996, 995, 994, 993, 992, 991, 990, 989, 988, 987, 986, 985, 984, 983, 982, 981, 980, 979, 978, 977, 976, 975, 974, 973, 972, 971, 970, 969, 968, 967, 966, 965, 964, 963, 962, 961, 960, 959, 958, 957, 956, 955, 954, 953, 952, 951, 950, 949, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 1};

        System.out.println(q.minimumMountainRemovals(nums));
    }
}
