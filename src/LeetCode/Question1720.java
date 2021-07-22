package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:31 2021/5/6
 * description 解码异或后的数组 经编码后变为长度为 n - 1 的另一个整数数组 encoded ，其中 encoded[i] = arr[i] XOR arr[i + 1]
 * node: 解码同样的异或操作
 * path: https://leetcode-cn.com/problems/decode-xored-array/
 * level: easy
 **/
public class Question1720 {
    public int[] decode(int[] encoded, int first) {
        int[] res = new int[encoded.length + 1];

        res[0] = first;
        for (int i = 1; i < res.length; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        Question1720 q = new Question1720();
        int[] encoded = {1, 2, 3};
        System.out.println(Arrays.toString(q.decode(encoded, 1)));
    }
}
