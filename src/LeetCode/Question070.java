package LeetCode;

/**
 * @author Struggle
 * @date Created in 20:47 2021/3/30
 * description Climbing Stairs 爬楼梯, 一次走一步或者两步, 走k阶楼梯有多少种走法
 * node: 斐波那契数列
 * path: https://leetcode.com/problems/climbing-stairs/
 * level: easy
 **/
public class Question070 {

    public int climbStairs(int n) {
        if (n <= 2) {
            return 1;
        }

        int[] f = new int[n + 1];
        f[0] = 1;
        f[1] = 1;

        for (int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }

    /**
     * 递归会超时, 里面有重复计算的过程
     *
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        if (n > 1) {
            return climbStairs2(n - 1) + climbStairs2(n - 2);
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Question070 q = new Question070();

        System.out.println(q.climbStairs(1000));
    }
}
