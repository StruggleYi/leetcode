package LeetCode;

/**
 * @author Struggle
 * @date Created in 2024/8/21 22:47
 * description 价值和小于等于 K 的最大数字
 * node: 二分查找 数位DP
 * path: https://leetcode.cn/problems/maximum-number-that-sum-of-the-prices-is-less-than-or-equal-to-k/description/?envType=daily-question&envId=2024-08-21
 * level: medium
 **/
public class Question3007 {

    public long findMaximumNumber(long k, int x) {
        long l = 1, r = (k + 1) << x;
        while (l < r) {
            long m = (l + r + 1) / 2;
            if (accumulatedPrice(x, m) > k) {
                r = m - 1;
            } else {
                l = m;
            }
        }
        return l;
    }

    public long accumulatedPrice(int x, long num) {
        long res = 0;
        int length = 64 - Long.numberOfLeadingZeros(num);
        for (int i = x; i <= length; i += x) {
            res += accumulatedBitPrice(i, num);
        }
        return res;
    }

    public long accumulatedBitPrice(int x, long num) {
        long period = 1L << x;
        long res = period / 2 * (num / period);
        if (num % period >= period / 2) {
            res += num % period - (period / 2 - 1);
        }
        return res;
    }
}
