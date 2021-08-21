package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 23:30 2021/8/11
 * description 给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目
 * node:
 * path: https://leetcode-cn.com/problems/arithmetic-slices-ii-subsequence/
 * level: hard
 **/
public class Question446 {
    public int numberOfArithmeticSlices(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
            list.add(i);
            if (list.size() == 1)
                map.put(nums[i], list);
        }
        int[][] dp = new int[nums.length][nums.length];
        // dp[j][i] 代表以j i 结尾的等差数列，这样就可以记录差值
        int cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                long num = 2L * nums[j] - nums[i];
                if (num > Integer.MAX_VALUE || num < Integer.MIN_VALUE)
                    continue;
                if (map.containsKey((int) num)) {
                    for (Integer k : map.get((int) num)) {
                        if (k < j)
                            dp[j][i] += dp[k][j] + 1;
                    }
                }
                cnt += dp[j][i];
            }
        }
        return cnt;
    }
}
