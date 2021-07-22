package LeetCode;

/**
 * @author Struggle
 * @date Created in 20:17 2021/6/2
 * description 连续的子数组和  给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组
 * 规则如下: 子数组大小 至少为 2 ，且子数组元素总和为 k 的倍数
 * node:
 * path: https://leetcode-cn.com/problems/continuous-subarray-sum/
 * level: medium
 **/
public class Question523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int len = nums.length;

        long[] sum = new long[len];
        sum[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sum[i] = sum[i - 1] + nums[i];
            // 有一种很特殊的情况, 如果存在连续两位是0的情况, 也满足条件, 因为0也是k的倍数
            if (sum[i] % k == 0 || (nums[i] == 0 && nums[i - 1] == 0)) {
                return true;
            }
        }

        for (int i = 1; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                long count = sum[j] - sum[i - 1];

                if (count % k == 0) {
                    return true;
                }

                // j从最大的开始剪枝, 避免计算小于k的情况
                if (count < k) {
                    break;
                }
            }
        }

        return false;
    }

    /**
     * 执行速度更快的解法
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum2(int[] nums, int k) {
        // 判断是否出现两个连续0的情况
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0 && nums[i + 1] == 0) {
                return true;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum % k == 0) {
                    return true;
                }
            }
            // 因为越往后 最终的和会越小, 所以当i->len-1都小于k, i+1->len-1也均不会大于k
            if (sum < k) {
                break;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Question523 q = new Question523();
        int[] nums = {23, 2, 4, 6, 7};
        System.out.println(q.checkSubarraySum(nums, 6));
    }
}
