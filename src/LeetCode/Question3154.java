package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:14 2024/8/20
 * description 到达第 K 级台阶的方案数
 * node: 往前走的步数指数增长，不会特别多，往后走由于不能连续，则可以考虑插空法，插入到走的方法中
 * 确定往前走的步长，即可确认后退的步数，从而获取方案数
 * path: https://leetcode.cn/problems/find-number-of-ways-to-reach-the-k-th-stair/description/?envType=daily-question&envId=2024-08-20
 * level: hard
 **/
public class Question3154 {

    public int waysToReachStair(int k) {
        int n = 0, npow = 1, ans = 0;
        while (true) {
            if (npow - n - 1 <= k && k <= npow) {
                ans += comb(n + 1, npow - k);
            } else if (npow - n - 1 > k) {
                break;
            }
            ++n;
            npow *= 2;
        }
        return ans;
    }

    public int comb(int n, int k) {
        long ans = 1;
        for (int i = n; i >= n - k + 1; --i) {
            ans *= i;
            ans /= n - i + 1;
        }
        return (int) ans;
    }

}
