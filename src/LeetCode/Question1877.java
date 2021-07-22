package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:22 2021/7/20
 * description 数组中最大数对和的最小值 将数字分为两两分组, 使得每组两个数字和最小, 返回其中最大和
 * node: 贪心思想, 数组排序过后, 首位依次选择, 其中某组值最大则为所求
 * path: https://leetcode-cn.com/problems/minimize-maximum-pair-sum-in-array/
 * level: medium
 **/
public class Question1877 {

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);

        int len = nums.length;
        int max = nums[0] + nums[len - 1];
        int i = 1;
        while (i < len / 2) {
            max = Math.max(max, nums[i] + nums[len - i - 1]);
            i++;
        }

        return max;
    }

}
