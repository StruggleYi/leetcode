package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:36 2021/7/8
 * description 和相同的二元子数组  给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组
 * node:
 * path: https://leetcode-cn.com/problems/binary-subarrays-with-sum/
 * level: medium
 **/
public class Question930 {

    /**
     * LeetCode 借鉴解法
     *
     * @param nums
     * @param k
     * @return
     */
    public int numSubarraysWithSum(int[] nums, int k) {
        //使用滑动窗口来完成, 所有值不大于K的子数组的个数减去所以值不大于K-1的子数组个数即为所求
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    /**
     * 计算和为 1->K 的子数组的个数
     *
     * @param nums
     * @param k
     * @return
     */
    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0;
        int i = 0, res = 0;
        for (int j = 0; j < nums.length; j++) {
            k -= nums[j];

            // 左节点向右滑动, 窗口内的值不能大于K
            while (k < 0) {
                k += nums[i];
                i++;
            }
            // 这样计算的原因在于: 子数组的长度等于能以最右边为终点的连续子串的个数
            // 因为 res 计算的是所有子串长度小于等于K的个数, 所以不需要计算出具体子串长度为 M的数目
            res += j - i + 1;
        }
        return res;
    }

    /**
     * 首次AC解法
     *
     * @param nums
     * @param goal
     * @return
     */
    public int numSubarraysWithSum2(int[] nums, int goal) {
        int n = nums.length;
        int[][] dp = new int[2][goal + 2];

        dp[0][nums[0]] = 1;
        int count = 0;
        for (int i = 1; i < n; i++) {
            int k = nums[i];
            for (int j = 0; j <= goal; j++) {
                if (k == 0) {
                    dp[1][j] = dp[0][j];
                } else {
                    if (j > 0) {
                        dp[1][j] = dp[0][j - 1];
                    }
                }
                if (j == k) {
                    dp[1][j]++;
                }
            }
            count += dp[0][goal];
            dp[0] = dp[1];
            dp[1] = new int[goal + 2];
        }
        count += dp[0][goal];
        return count;
    }
}
