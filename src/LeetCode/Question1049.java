package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:27 2021/6/8
 * description 最后一块石头的重量 II  有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量
 *             每次选两块石头, 假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
 *             如果 x == y，那么两块石头都会被完全粉碎
 *             如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x
 *             最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0
 * node: 由于石头最后只会剩下一块, 最终所有的石头都会面临选择, 要么被全部砸完, 要么砸别人, 最后留下来的重量为 k * stones[i] 其中k = 1 或者 -1
 * path: https://leetcode-cn.com/problems/last-stone-weight-ii/
 * level: medium
 **/
public class Question1049 {

    /**
     * 题目转化为 求 stones 中的每个数字添加 +/-，使得形成的「计算表达式」结果绝对值最小
     * 可以理解为背包问题, 两个背包各装重量为 M 和 N 的石头, M看做 + , N看做 -
     * 最后一块石头的重量要最小, 即两个背包的石头重量差距越小
     * 重量差为M - N, 即 all - 2 * N, 由于总重量一定, 想要差值越小, 即N 越大
     * 又可以转化为, 如何在重量为 all / 2 的背包中装最多的重量的问题
     * @param stones
     * @return
     */
    public int lastStoneWeightII(int[] stones) {
        int n = stones.length;
        int sum = 0;
        for (int i : stones) {
            sum += i;
        }
        // 小背包最大容量
        int t = sum / 2;
        int[] f = new int[t + 1];

        // 遍历每一块石头
        for (int i = 1; i <= n; i++) {
            int x = stones[i - 1];
            for (int j = t; j >= x; j--) {
                // 取要和不要这块石头 背包能装的最大值
                f[j] = Math.max(f[j], f[j - x] + x);
            }
        }
        return Math.abs(sum - f[t] - f[t]);
    }


    public static void main(String[] args) {
        Question1049 q = new Question1049();
        int[] stones = {31, 26, 33, 21, 40};
        System.out.println(q.lastStoneWeightII(stones));
    }
}
