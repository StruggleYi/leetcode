import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 22:04 2021/7/2
 * description 雪糕的最大数量
 * node:
 * path: https://leetcode-cn.com/problems/maximum-ice-cream-bars/
 * level: medium
 **/
public class Question1833 {

    /**
     * 这里不对价格进行排序, 而是分别求出每个价格商品的个数, 同样从低到高选择商品
     *
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream(int[] costs, int coins) {
        int max = 0;
        for (int x : costs) {
            if (x > max) {
                max = x;
            }
        }
        int[] arr = new int[max + 1];
        for (int x : costs) {
            arr[x]++;
        }
        int sum = 0, count = 0;
        for (int i = 1; i <= max; i++) {
            if (arr[i] > 0) {
                if (arr[i] * i + sum < coins) {
                    sum += arr[i] * i;
                    count += arr[i];
                } else {
                    count += (coins - sum) / i;
                    break;
                }
            }
        }
        return count;
    }

    /**
     * 从价格低往高选即可, 这里直接对价格进行排序
     *
     * @param costs
     * @param coins
     * @return
     */
    public int maxIceCream2(int[] costs, int coins) {
        int count = 0;

        Arrays.sort(costs);
        for (int k : costs) {
            if (coins - k < 0) {
                break;
            }
            count++;
            coins -= k;
        }

        return count;
    }

    public static void main(String[] args) {
        Question1833 q = new Question1833();
        int[] costs = {1, 6, 3, 1, 2, 5};
        System.out.println(q.maxIceCream(costs, 20));
    }
}
