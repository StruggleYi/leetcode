/**
 * @author Struggle
 * @date Created in 21:22 2021/5/9
 * description 制作 m 束花所需的最少天数  给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
 *                                      现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
 *                                      花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
 *                                      请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
 * node: 直接使用暴力法找出满足条件的天数会超时, 使用二分法即可
 * path: https://leetcode-cn.com/problems/minimum-number-of-days-to-make-m-bouquets/
 * level: medium
 **/
public class Question1482 {

    public int minDays(int[] bloomDay, int m, int k) {
        if (m * k > bloomDay.length) {
            return -1;
        }

        int len = bloomDay.length;
        int low = 0;
        int high = 1000000000;

        while (low < high) {

            int res = (low + high) / 2;
            // i 记录当前采的花的束数
            // j 记录遍历到第j朵花
            int i = 0;
            int j = 0;
            int z = 0;
            while (j < len) {
                if (bloomDay[j++] > res) {
                    z = 0;
                    continue;
                }
                z++;

                if (z == k) {
                    i++;
                    z = 0;

                    // 剩余的花不够时, 退出循环
                    if ((len - j) < (m - i) * k){
                        break;
                    }
                }

                if (i == m) {
                    break;
                }
            }

            if (i == m) {
                high = res;
            }else {
                low = res + 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        Question1482 q = new Question1482();
        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
        System.out.println(q.minDays(bloomDay, 2, 3));
    }
}
