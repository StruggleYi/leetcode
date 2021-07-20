import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:29 2021/7/19
 * description 最高频元素的频数
 * node:
 * path: https://leetcode-cn.com/problems/frequency-of-the-most-frequent-element/
 * level: medium
 **/
public class Question1838 {

    /**
     * 比较巧妙的方式, 采用滑动的形式, 判断当前满足要求的最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;

        // total记录的是把 l -> r 中所有数字变成 nums[r] 所需要的操作次数
        for (int r = 1; r < n; ++r) {
            // 这里乘以 (r - l) 的意思在于, r 之前的数字经过 total 步操作已经全部变成了 nums[r - 1]
            // 现在要将其变成 nums[r] 则需要把前面所有的数字都进行操作
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    /**
     * 首次AC比较慢的方式, 求出每个数字出现的个数, 并且计算该数字进过操作后可能达到的最大次数
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxFrequency2(int[] nums, int k) {
        int[] dp = new int[100001];

        int max = 0;
        int min = 100001;
        for (int num : nums) {
            dp[num]++;
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int count = 1;

        // 从最小的数字开始遍历
        for (int i = min; i < max + k && i < dp.length; i++) {

            // 如果该数字经过K次操作也达不到当前最大 或者 当前数字个数为0, 可直接跳过
            // 为0时可以跳过的原因在于：如果当前数字满足最大, 那么比它小的且存在的数字一样能够经过操作满足要求
            if (dp[i] + k <= count || dp[i] == 0) {
                continue;
            }

            int m = k;
            int j = i - 1;
            int n = 0;

            // 从后往前遍历, 判断哪些数字可以经过操作提升到当前数字的值
            while (m > 0 && j >= min) {
                if (m < j - i) {
                    break;
                }

                if (dp[j] > 0) {
                    int t = dp[j] * (i - j);

                    if (m >= t) {
                        m -= t;
                        n += dp[j];
                    } else {
                        n += (m / (i - j));
                        break;
                    }
                }
                j--;
            }

            count = Math.max(count, dp[i] + n);
        }

        return count;
    }

    public static void main(String[] args) {
        Question1838 q = new Question1838();
        int[] nums = {9930, 9923, 9983, 9997, 9934, 9952, 9945, 9914, 9985, 9982, 9970, 9932, 9985, 9902, 9975, 9990, 9922, 9990, 9994, 9937, 9996, 9964, 9943, 9963, 9911, 9925, 9935, 9945, 9933, 9916, 9930, 9938, 10000, 9916, 9911, 9959, 9957, 9907, 9913, 9916, 9993, 9930, 9975, 9924, 9988, 9923, 9910, 9925, 9977, 9981, 9927, 9930, 9927, 9925, 9923, 9904, 9928, 9928, 9986, 9903, 9985, 9954, 9938, 9911, 9952, 9974, 9926, 9920, 9972, 9983, 9973, 9917, 9995, 9973, 9977, 9947, 9936, 9975, 9954, 9932, 9964, 9972, 9935, 9946, 9966};
        System.out.println(q.maxFrequency(nums, 3056));
    }
}
