/**
 * @author Struggle
 * @date Created in 22:03 2021/4/21
 * description 寻找旋转排序数组中的最小值 数字不重复
 * node:
 * path: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
 *       https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * level: medium
 **/
public class Question153 {
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
