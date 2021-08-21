package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:27 2021/8/9
 * description 超级丑数  超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中
 * node:
 * path: https://leetcode-cn.com/problems/super-ugly-number/
 * level: medium
 **/
public class Question313 {
    public int nthSuperUglyNumber(int n, int[] primes) {

        // dp 用来记录丑数的值, dp[k] 代表第 k 个丑数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int m = primes.length;

        // pointers 用来记录每个质数当前指向丑数的位置, 默认从 1 开始计算
        int[] pointers = new int[m];
        Arrays.fill(pointers, 1);

        // 这里有个很巧妙的点在于：下一个最小的丑数其实是在每个质数中选取最小的那个
        // 这里的 pointers 就起到了很好的记录作用
        // 以 2,7,13,19 为例, 初始阶段, 每个值都需要与1相乘 获取到最小的丑数
        // 此时 1 * 2 是最小值, 2 这个质数由于已经乘过一次 下次计算他最小的值, 就应该从下个丑数开始计算了
        // pointers 就用来记录他所乘的丑数点的位置
        // 质数 m 与第 k 个丑数相乘获取到了最小的质数, 那么下一次他就只能和 第 k + 1 个质数相乘来去获取后面最小的质数
        // 否则计算的丑数已被计算过
        for (int i = 2; i <= n; i++) {
            int[] nums = new int[m];
            int minNum = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++) {
                nums[j] = dp[pointers[j]] * primes[j];
                minNum = Math.min(minNum, nums[j]);
            }
            dp[i] = minNum;

            // 这里的目的在于如果当前最小的数据已被计算过, 则往后移一次, 避免重复计算
            for (int j = 0; j < m; j++) {
                if (minNum == nums[j]) {
                    pointers[j]++;
                }
            }
        }
        return dp[n];
    }
}
