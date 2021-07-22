package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:07 2021/4/19
 * description 移除元素 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * node:
 * path: https://leetcode.com/problems/remove-element/
 * https://leetcode-cn.com/problems/remove-element/
 * level: easy
 **/
public class Question027 {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[index++] = nums[i];
        }

        return index;
    }

    public static void main(String[] args) {
        Question027 q = new Question027();
        int[] nums = {3, 2, 2, 3};
        System.out.println(q.removeElement(nums, 2));
    }
}
