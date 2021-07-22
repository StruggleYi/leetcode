package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:01 2021/4/16
 * description 寻找旋转排序数组中的最小值 数字可能重复
 * node: 暴力破解
 * path: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
 *       https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 * level: hard
 **/
public class Question154 {

    public int findMin(int[] nums) {
        int min = nums[0];

        for (int i = 1;i < nums.length; i++){
            if (nums[i] < min){
                return nums[i];
            }
        }
        return min;
    }
}
