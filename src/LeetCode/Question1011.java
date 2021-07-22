package LeetCode;

/**
 * @author Struggle
 * @date Created in 19:24 2021/4/26
 * description 在 D 天内送达包裹的能力 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力
 * node:
 * path: https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
 * level: medium
 **/
public class Question1011 {

    /**
     * 优化一点点的解法, 不逐步加一, 采用二分法来确定最小值
     * 因为如果D能够满足运载, 那么大于D均满足; 如果D不满足运载, 那么小于等于D均不满足运载
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays(int[] weights, int D) {
        int min = 0;

        for (int i = 0; i < weights.length; i++) {
            min = Math.max(min, weights[i]);
        }

        int max = min * weights.length / D + 1;
        while (min < max) {
            int mid = min + max >> 1;
            if (check(weights, D, mid)) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }
        return max;
    }

    private boolean check(int[] weights, int D, int t) {
        int k = 1;
        int pre = 0;
        int i = 0;
        while (k <= D) {
            while (i < weights.length) {
                if (pre + weights[i] > t) {
                    pre = 0;
                    break;
                }
                pre += weights[i];
                i++;
            }
            k++;
        }
        return i == weights.length;
    }


    /**
     * 暴力解法
     * 找出D理论上的最小值, 然后逐渐加一, 直到找到符合要求的最小值
     *
     * @param weights
     * @param D
     * @return
     */
    public int shipWithinDays2(int[] weights, int D) {
        int res = weights[0];
        int sum = res;

        for (int i = 1; i < weights.length; i++) {
            res = Math.max(res, weights[i]);
            sum += weights[i];
        }

        res = Math.max(res, sum / D);
        while (true) {
            int k = 1;
            int pre = 0;
            int i = 0;
            while (k <= D) {
                while (i < weights.length) {
                    if (pre + weights[i] > res) {
                        pre = 0;
                        break;
                    }
                    pre += weights[i];
                    i++;
                }
                k++;
            }
            if (i == weights.length) {
                break;
            }
            res++;
        }

        return res;
    }

    public static void main(String[] args) {
        Question1011 q = new Question1011();
        int[] weights = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(q.shipWithinDays(weights, 5));
    }
}
