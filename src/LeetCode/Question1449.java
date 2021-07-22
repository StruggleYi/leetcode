package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:14 2021/6/12
 * description 数位成本和为目标值的最大数字  当前结果添加一个数位（i + 1）的成本为 cost[i]  总成本必须恰好等于 target
 * node:
 * path: https://leetcode-cn.com/problems/form-largest-integer-with-digits-that-add-up-to-target/
 * level: hard
 **/
public class Question1449 {

    /**
     * 个人思路: 可以先通过动态规划, 计算出构建成target的最多数字的个数, 然后倒过头来求每一位是哪个数字
     * 原因: 本题没有0, 所以最终的数字越大, 则需要的位数越大
     *      当我们最初使用动态规划时, 就可以计算出组成成本为i的最大数字个数
     *      当从9开始判断, 如果能够使用9,并且剩下的数字成本个数与我们要组成的个数减一相同, 那么改数字就放在最高位, 继续求下一位数字
     *      知道求完每一位的数字
     * @param cost
     * @param target
     * @return
     */
    public String largestNumber(int[] cost, int target) {

        // dp[i]代表构成 i 的最多数字的个数
        int[] dp = new int[target + 1];
        for (int j = 0; j < 9; j++) {

            for (int i = cost[j]; i <= target; i++) {

                // 当成本与i相等时, 可以满足要求
                if (cost[j] == i) {
                    dp[i] = Math.max(dp[i], 1);
                }
                // i - cost[j] 能够构成数字时, 累加计算才有意义
                if (cost[j] <= i && dp[i - cost[j]] != 0) {
                    dp[i] = Math.max(dp[i], dp[i - cost[j]] + 1);
                }
            }
        }

        StringBuilder res = new StringBuilder();

        int len = dp[target];

        // 如果不能求到结果, 返回0
        if (len == 0) {
            return "0";
        }

        while (len-- > 0) {

            // 从9开始判断, 是因为相同成本的数字有高有低, 应该优先选择高的
            for (int i = 8; i >= 0; i--) {

                // 从最高位开始, 计算满足要求的数字
                // 如果是最后一位, 那么所需成本与剩余目标数字匹配即可
                if (len == 0 && target == cost[i]) {
                    res.append(i + 1);
                    break;
                } else if (target - cost[i] > 0 && len > 0 && dp[target - cost[i]] == len) {

                    // 如果不是最后一位, 那么需要判断使用该数字时, 剩余的成本能构成的位数是否满足要求
                    res.append(i + 1);
                    target -= cost[i];
                    break;
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Question1449 q = new Question1449();
        int[] cost = {4, 3, 2, 5, 6, 7, 2, 5, 5};
        System.out.println(q.largestNumber(cost, 9));
    }
}
