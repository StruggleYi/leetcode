/**
 * @author Struggle
 * @date Created in 20:37 2021/1/12
 * description Fruit Into Baskets 给定一串水果种类，给定两个篮子，要求在每个篮子只能装一个种类的水果，返回能装最多水果的个数
 * node: 转换一下题意, 就是求给定一串数字中，两个数字最大连续出现的次数
 * path: https://leetcode.com/problems/fruit-into-baskets/
 * level: medium
 **/

public class Question904 {
    public int totalFruit(int[] tree) {
        if (tree == null || tree.length == 0) {
            return 0;
        }

        int m = tree[0];
        int max = 0;
        int i;
        for (i = 1; i < tree.length; i++) {
            if (tree[i] == m) {
                max++;
            } else {
                break;
            }
        }
        // 如果只有一种水果的情况
        if (i == tree.length) {
            return tree.length;
        }

        // a,b 分别记录此次 水果m,n 的最后位置
        int a = 0;
        int b = i;
        int n = tree[i++];

        // 记录计算的起始位置，用于计算当前已装的水果数
        int k = 0;

        for (; i < tree.length; i++) {
            int target = tree[i];
            // 如果当前记录的水果是两个篮子中已有的类型，则直接 +1
            if (target == m) {
                a = i;
                continue;
            } else if (target == n) {
                b = i;
                continue;
            }
            max = Math.max(max, i - k);
            if (m == tree[i - 1]) {
                n = target;
                i = b;
            } else {
                m = target;
                i = a;
            }
            k = i + 1;
        }
        return Math.max(max, i - k);
    }

    public static void main(String[] args) {
        Question904 q = new Question904();
        int[] tree = {3};
        System.out.println(q.totalFruit(tree));
    }
}
