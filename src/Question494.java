import java.util.ArrayDeque;

/**
 * @author Struggle
 * @date Created in 23:05 2021/6/7
 * description 目标和 给你一个整数数组 nums 和一个整数 target 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目
 * node: 本题值得推荐, 有许多地方值得思考
 * path: https://leetcode-cn.com/problems/target-sum/
 * level: medium
 **/
public class Question494 {

    /**
     * 最后附上时间使用最少的答案
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays5(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum < target) {
            return 0;
        }
        if ((sum + target) % 2 == 1) {
            return 0;
        }
        int bagSize = (sum + target) / 2;
        int[] dp = new int[bagSize + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int j = bagSize; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        return dp[bagSize];
    }


    /**
     * 动态规划, 规避很多重复计算值
     * 具体解答参照： https://leetcode-cn.com/problems/target-sum/solution/gong-shui-san-xie-yi-ti-si-jie-dfs-ji-yi-et5b/
     */
    public int findTargetSumWays(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        for (int i : nums) {
            s += Math.abs(i);
        }
        if (t > s || (s - t) % 2 != 0) {
            return 0;
        }
        int m = (s - t) / 2;
        int[][] f = new int[n + 1][m + 1];
        f[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = 0; j <= m; j++) {
                f[i][j] += f[i - 1][j];
                if (j >= x) {
                    f[i][j] += f[i - 1][j - x];
                }
            }
        }
        return f[n][m];
    }


    /**
     * 动态规划 dp[i][j] 代表前i个数, 和为j的值的个数
     * f[i][j]= f[i−1][j−nums[i−1]] + f[i−1][j+nums[i−1]]
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays2(int[] nums, int t) {
        int n = nums.length;
        int s = 0;
        // 遍历计算和的大小, 因为涉及到负数, 所以数组需要统一加上固定的数
        for (int i : nums) {
            s += Math.abs(i);
        }
        if (t > s) {
            return 0;
        }
        int[][] f = new int[n + 1][2 * s + 1];
        f[0][s] = 1;
        for (int i = 1; i <= n; i++) {
            int x = nums[i - 1];
            for (int j = -s; j <= s; j++) {
                if ((j - x) + s >= 0) {
                    f[i][j + s] += f[i - 1][(j - x) + s];
                }
                if ((j + x) + s <= 2 * s) {
                    f[i][j + s] += f[i - 1][(j + x) + s];
                }
            }
        }
        return f[n][t + s];
    }


    /**
     * 暴力递归, dfs搜索
     *
     * @param nums
     * @param t
     * @return
     */
    public int findTargetSumWays3(int[] nums, int t) {
        return dfs(nums, t, 0, 0);
    }

    int dfs(int[] nums, int t, int u, int cur) {
        if (u == nums.length) {
            return cur == t ? 1 : 0;
        }
        int left = dfs(nums, t, u + 1, cur + nums[u]);
        int right = dfs(nums, t, u + 1, cur - nums[u]);
        return left + right;
    }


    /**
     * 暴力做法, 第一次思路, 记录所有的结果
     *
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays4(int[] nums, int target) {
        int n = nums.length;
        int res = 0;
        if (n == 1) {
            if (nums[0] == target) {
                res++;
            }
            if (nums[0] == -target) {
                res++;
            }
            return res;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(nums[0]);

        for (int i = 1; i < n - 1; i++) {
            int k = (int) Math.pow(2, i - 1);

            while (k-- > 0) {
                int num = queue.pop();
                queue.add(num + nums[i]);
                queue.add(num - nums[i]);
            }
        }

        while (!queue.isEmpty()) {
            int num = queue.pop();

            int a = num + nums[n - 1];
            int b = num - nums[n - 1];

            if (a == target) {
                res++;
            }
            if (a == -target) {
                res++;
            }

            if (b == target) {
                res++;
            }
            if (b == -target) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Question494 q = new Question494();
        int[] nums = {1, 1};
        System.out.println(q.findTargetSumWays(nums, 0));
    }
}
