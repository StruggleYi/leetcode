import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:22 2021/4/13
 * description Product of Array Except Self 给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积
 * node: 阶梯计算法, 顺序算一次乘积, 逆序算一次乘积
 * path: https://leetcode.com/problems/product-of-array-except-self/
 * level: medium
 **/
public class Question238 {

    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        res[0] = 1;
        int num = 1;
        for (int i = 1; i < len; i++) {
            num *= nums[i - 1];
            res[i] = num;
        }

        num = 1;
        for (int i = len - 2; i >= 0; i--) {
            num *= nums[i + 1];
            res[i] *= num;
        }

        return res;
    }

    public static void main(String[] args) {
        Question238 q = new Question238();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(q.productExceptSelf(nums)));
    }
}
