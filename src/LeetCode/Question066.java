package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 20:18 2021/3/30
 * description Plus One 给定一个非空的整形数组, 将其当做一个大整数, 将其进行加一操作
 * node: 控制进位即可
 * path: https://leetcode.com/problems/plus-one/
 * level: easy
 **/
public class Question066 {

    public int[] plusOne(int[] digits) {
        int len = digits.length;

        int k = 1;
        while (len-- > 0) {
            int sum = digits[len] + k;
            k = sum / 10;
            digits[len] = sum % 10;
        }

        if (k == 0) {
            return digits;
        }

        int[] res = new int[digits.length + 1];
        res[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            res[i + 1] = digits[i];
        }

        return res;
    }

    public static void main(String[] args) {
        Question066 q = new Question066();

        int[] digits = {9, 9, 9, 9, 9};
        System.out.println(Arrays.toString(q.plusOne(digits)));
    }
}
