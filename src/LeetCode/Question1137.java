package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:26 2021/8/8
 * description 第 N 个泰波那契数 泰波那契序列 Tn 定义如下： 
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 * node:
 * path: https://leetcode-cn.com/problems/n-th-tribonacci-number/
 * level: easy
 **/
public class Question1137 {
    int[] dp = new int[38];

    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }

        if (n <= 2) {
            return 1;
        }

        int a = dp[n - 3] == 0 ? tribonacci(n - 3) : dp[n - 3];
        int b = dp[n - 2] == 0 ? tribonacci(n - 2) : dp[n - 2];
        int c = dp[n - 1] == 0 ? tribonacci(n - 1) : dp[n - 1];

        dp[n] = a + b + c;
        return dp[n];
    }
}
