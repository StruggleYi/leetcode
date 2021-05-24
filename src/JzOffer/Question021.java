package JzOffer;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:47 2021/5/24
 * description  调整数组顺序使奇数位于偶数前面  输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分
 * node:
 * path: https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * level: easy
 **/
public class Question021 {

    public int[] exchange(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            while (i < j && nums[i] % 2 == 1) {
                i++;
            }

            while (i < j && nums[j] % 2 == 0) {
                j--;
            }

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        return nums;
    }

    public static void main(String[] args) {
        Question021 q = new Question021();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(q.exchange(nums)));
    }
}
