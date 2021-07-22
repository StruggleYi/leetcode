package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:05 2021/4/24
 * description 合总和 Ⅳ 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数, 顺序不同的序列被视作不同的组合
 * node: 动态规划
 * path: https://leetcode.com/problems/combination-sum-iv/
 * https://leetcode-cn.com/problems/combination-sum-iv/
 * level: medium
 **/
public class Question377 {


    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int num : nums) {
                if (num <= i) {
                    dp[i] += dp[i - num];
                }
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        Question377 q = new Question377();
        int[] nums = {3, 1, 2, 4};
        System.out.println(q.combinationSum4(nums, 4));
    }
}
