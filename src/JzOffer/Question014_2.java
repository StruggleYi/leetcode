package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:12 2021/5/10
 * description 剪绳子 II   给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段 （m、n都是整数，n>1并且m>1） 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。
 *                          请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 *                          答案需要取模 1e9+7（1000000007）
 * node: 本题不同点在于, 在相乘的时候就要取模, 不能只对最终的结果取模
 * path: https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * level: medium
 **/
public class Question014_2 {
    public int cuttingRope(int n) {
        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        // 小于等于4的时候不剪的乘积比较大, 大于4的时候可以拆分出3
        while (n > 4) {
            res = (res * 3) % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }
}
