package JzOffer;

/**
 * @author Struggle
 * @date Created in 16:37 2021/7/17
 * description 连续子数组的最大和
 * node:
 * path: https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
 * level: easy
 **/
public class Question042 {

    public int maxSubArray(int[] nums) {
        int pre = 0;
        int max = nums[0];

        for (int num : nums) {
            pre = Math.max(pre + num, num);
            max = Math.max(max, pre);
        }

        return max;
    }

    public static void main(String[] args) {
        Question042 q = new Question042();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(q.maxSubArray(nums));
    }
}
