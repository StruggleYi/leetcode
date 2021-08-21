package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:29 2021/8/10
 * description 等差数列划分 给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数   至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列
 * node:
 * path: https://leetcode-cn.com/problems/arithmetic-slices/
 * level: medium
 **/
public class Question413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;

        int count = 0;
        // 长度小于3, 不能够成等差数列
        for (int i = 0; i < len - 2; ) {

            // 从 i 开始 判断满足等差数列的个数
            int k = nums[i + 1] - nums[i];
            int j = i + 2;
            while (j < len) {
                if (nums[j] - nums[j - 1] == k) {
                    j++;
                } else {
                    break;
                }
            }

            // 满足条件子数列个数大于2, 则满足等差数列定义
            int n = j - i;
            if (n > 2) {
                count += (n - 1) * (n - 2) / 2;
                i = j - 1;
            } else {
                i++;
            }
        }

        return count;
    }
}
