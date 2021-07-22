package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 2020/11/3 10:47
 * description Next Greater Element I 找出下一个比自己大的数
 * node:
 * path: https://leetcode.com/problems/next-greater-element-i/
 * level: easy
 **/
public class Question496 {
    public int[] nextGreaterElement(int[] num1, int[] num2) {
        List<Integer> list = new ArrayList<>();
        for (int value : num2) {
            list.add(value);
        }
        for (int i = 0; i < num1.length; i++) {
            int j = list.indexOf(num1[i]) + 1;
            for (; j < num2.length; j++) {
                if (num2[j] > num1[i]) {
                    num1[i] = num2[j];
                    break;
                }
            }
            if (j == num2.length) {
                num1[i] = -1;
            }
        }
        return num1;
    }

    public static void main(String[] args) {
        Question496 q = new Question496();
        int[] num1 = {4, 1, 2};
        int[] num2 = {1, 3, 4, 2};
        System.out.println(Arrays.toString(q.nextGreaterElement(num1, num2)));
    }
}
