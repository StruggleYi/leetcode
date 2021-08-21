package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:36 2021/8/16
 * description 优美的排列  假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列
 * perm[i] 能够被 i 整除
 * i 能够被 perm[i] 整除
 * node:
 * path: https://leetcode-cn.com/problems/beautiful-arrangement/
 * level: medium
 **/
public class Question526 {
    int[] flag = new int[16];
    int res = 0;

    public int countArrangement(int n) {
        if (n <= 2) {
            return n;
        }
        count(n, 1);
        return res;
    }

    private void count(int n, int k) {

        // 所有数字安排完毕
        if (k > n) {
            res++;
            return;
        }

        // 找到满足条件1的数字（第 i 位的数字能被 i 整除）
        int i = 1;
        while (k >= i) {
            if (k % i == 0 && flag[k / i] == 0) {
                flag[k / i] = 1;
                count(n, k + 1);
                flag[k / i] = 0;
            }
            i++;
        }

        // 找到满足条件2的数字（i 能被第 i 位上的数字整除）
        // i 从 2 开始的原因在于 相等的值在条件1已经计算过
        i = 2;
        while (k * i <= n) {
            if (flag[k * i] == 0) {
                flag[k * i] = 1;
                count(n, k + 1);
                flag[k * i] = 0;
            }
            i++;
        }
    }

}
