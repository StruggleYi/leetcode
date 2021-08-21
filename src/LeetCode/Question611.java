package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:22 2021/8/4
 * description 有效三角形的个数
 * node:
 * path: https://leetcode-cn.com/problems/valid-triangle-number/
 * level: medium
 **/
public class Question611 {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            int index = i + 2;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int target = nums[i] + nums[j];
                while (index < nums.length && nums[index] < target) {
                    index++;
                }
                res += Math.max(0, index - 1 - j);
            }
        }
        return res;
    }
}
