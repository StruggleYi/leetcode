package Interview;

/**
 * @author Struggle
 * @date Created in 21:46 2021/7/9
 * description 主要元素 数组中占比超过一半的元素称之为主要元素。给你一个 整数 数组，找出其中的主要元素。若没有，返回 -1 。请设计时间复杂度为 O(N) 、空间复杂度为 O(1) 的解决方案
 * node:
 * path: https://leetcode-cn.com/problems/find-majority-element-lcci/
 * level: easy
 **/
public class Question017_10 {

    /**
     * 比较经典的题目, 用一个数字去记录个数即可, 如果有某个数字满足要求, 那么他最后计算的数目肯定大于0， 最后验证一下大于0的数字的个数是否大于一半即可
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        if (nums.length <= 1) {
            return nums[0];
        }

        int k = 1;
        int m = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (k == 0) {
                k++;
                m = nums[i];
            } else if (m == nums[i]) {
                k++;
            } else {
                k--;
            }
        }

        k = 0;
        for (int num : nums) {
            if (num == m) {
                k++;
            }
        }

        return nums.length / 2 < k ? m : -1;
    }

    public static void main(String[] args) {
        Question017_10 q = new Question017_10();
        int[] nums = {1, 2, 5, 9, 5, 9, 5, 5, 5};
        System.out.println(q.majorityElement(nums));
    }

}
