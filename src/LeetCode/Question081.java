package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:05 2021/4/16
 * description 搜索旋转排序数组 II 判断给定的目标值是否存在于数组中
 * node:
 * path: https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 *       https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/
 * level: medium
 **/
public class Question081 {
    public boolean search(int[] nums, int target) {

        for (int k : nums) {
            if (k == target) {
                return true;
            }
        }
        return false;
    }
}
