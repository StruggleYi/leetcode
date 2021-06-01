import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:12 2021/6/1
 * description 你能在你最喜欢的那天吃到你最喜欢的糖果吗？
 * answer[i] 为 true 的条件是：在每天吃 不超过 dailyCapi 颗糖果的前提下，你可以在第 favoriteDayi 天吃到第 favoriteTypei 类糖果；否则 answer[i] 为 false
 * 规则：1、你从第 0 天开始吃糖果；
 * 2、你在吃完所有第 i - 1 类糖果之前，不能吃任何一颗第 i 类糖果；
 * 3、在吃完所有糖果之前，你必须每天至少吃一颗糖果。
 * node: 规则二很重要, 需要依次吃每种类型的糖果
 * path: https://leetcode-cn.com/problems/can-you-eat-your-favorite-candy-on-your-favorite-day/
 * level: medium
 **/
public class Question1744 {


    long[] sum = new long[100001];

    /**
     * @param candiesCount 表示你拥有的第 i 类糖果的数目
     * @param queries
     * @return
     */
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        boolean[] res = new boolean[queries.length];
        sum[0] = candiesCount[0];
        for (int i = 1; i < candiesCount.length; i++) {
            sum[i] = sum[i - 1] + candiesCount[i];
        }

        for (int i = 0; i < queries.length; i++) {
            res[i] = judge(queries[i][0], queries[i][1], queries[i][2]);
        }

        return res;
    }

    /**
     * 判断 第 d 天能否吃到 t 类糖果
     *
     * @param type
     * @param day
     * @param num
     * @return
     */
    private boolean judge(int type, int day, int num) {
        // 第 d 天能够吃到的最多与最少糖果数
        long max = (long) num * (day + 1);
        long min = day + 1;

        // 吃到类型 t 的糖果, 最多可以吃与最少需要吃的糖果数
        long tMax = sum[type];
        long tMin = type == 0 ? 1 : sum[type - 1] + 1;

        // 两个范围之间有交叉, 则代表可以吃到
        return tMax >= min && tMin <= max;
    }

    public static void main(String[] args) {
        Question1744 q = new Question1744();
        int[] candiesCount = {5215, 14414, 67303, 93431, 44959, 34974, 22935, 64205, 28863, 3436, 45640, 34940, 38519, 5705, 14594, 30510, 4418, 87954, 8423, 65872, 79062, 83736, 47851, 64523, 15639, 19173, 88996, 97578, 1106, 17767, 63298, 8620, 67281, 76666, 50386, 97303, 26476, 95239, 21967, 31606, 3943, 33752, 29634, 35981, 42216, 88584, 2774, 3839, 81067, 59193, 225, 8289, 9295, 9268, 4762, 2276, 7641, 3542, 3415, 1372, 5538, 878, 5051, 7631, 1394, 5372, 2384, 2050, 6766, 3616, 7181, 7605, 3718, 8498, 7065, 1369, 1967, 2781, 7598, 6562, 7150, 8132, 1276, 6656, 1868, 8584, 9442, 8762, 6210, 6963, 4068, 1605, 2780, 556, 6825, 4961, 4041, 4923, 8660, 4114};
        int[][] queries = {{91, 244597, 840227137}};
        System.out.println(Arrays.toString(q.canEat(candiesCount, queries)));
    }
}
