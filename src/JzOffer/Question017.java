package JzOffer;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:47 2021/5/13
 * description 打印从1到最大的n位数
 * node:
 * path: https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * level: easy
 **/
public class Question017 {
    public int[] printNumbers(int n) {
        int[] res = new int[(int) Math.pow(10, n) - 1];
        res[0] = 1;
        for (int i = 1; i < res.length; i++) {
            res[i] = res[i - 1] + 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Question017 q = new Question017();
        System.out.println(Arrays.toString(q.printNumbers(10)));
    }
}
