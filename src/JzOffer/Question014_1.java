package JzOffer;

/**
 * @author Struggle
 * @date Created in 22:46 2021/5/9
 * description 剪绳子  给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少
 * node:
 * path: https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * level: medium
 **/
public class Question014_1 {
    /**
     * 贪心算法, 尽可能多的取长度为3的子段, 乘积可以达到最大
     * 证明参考：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     */
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        int res = 1;
        // 小于等于4的时候不剪的乘积比较大, 大于4的时候可以拆分出3
        while (n > 4) {
            res *= 3;
            n -= 3;
        }
        return res * n;
    }

    /**
     * 常规动态规划思想, 使用数组记录长度为k的绳子的最大乘积
     *
     * @param n
     * @return
     */
    public int cuttingRope2(int n) {
        if (n <= 3) {
            return n - 1;
        }

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = (i - 2) * 2;
            for (int j = 3; i - j >= 2; j++) {
                // 取dp[i - j], i - j的最大值是因为 可以剪也可以不剪
                dp[i] = Math.max(dp[i], Math.max(dp[i - j], i - j) * j);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        Question014_1 q = new Question014_1();
        System.out.println(q.cuttingRope(6));
    }
}
