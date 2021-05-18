import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 23:41 2021/5/16
 * description 数组中两个数的最大异或值
 * node:
 * path: https://leetcode-cn.com/problems/maximum-xor-of-two-numbers-in-an-array/
 * level: medium
 **/
public class Question421 {

    /**
     * 借鉴解法
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int len = 32 - Integer.numberOfLeadingZeros(max);
        Set<Integer> prefix = new HashSet<>();
        int maxXOR = 0;
        for (int i = len - 1; i >= 0; i--) {
            maxXOR <<= 1;
            int curPrefix = maxXOR | 1;
            prefix.clear();
            for (int num : nums) {
                prefix.add(num >> i);
                if (prefix.contains(num >> i ^ curPrefix)) {
                    maxXOR |= 1;
                    break;
                }
            }
        }
        return maxXOR;
    }

    /**
     * 暴力解法
     *
     * @param nums
     * @return
     */
    public int findMaximumXOR2(int[] nums) {
        int max = 0;

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                max = Math.max(max, nums[i] ^ nums[j]);
            }
        }

        return max;
    }
}
