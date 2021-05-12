import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:36 2021/5/11
 * description 解码异或后的排列  给你一个整数数组 perm ，它是前 n 个正整数的排列，且 n 是个 奇数 。
 *                             它被加密成另一个长度为 n - 1 的整数数组 encoded ，满足 encoded[i] = perm[i] XOR perm[i + 1] 。比方说，如果 perm = [1,3,2] ，那么 encoded = [2,1] 。
 *                             给你 encoded 数组，请你返回原始数组 perm
 * node: 数组perm 1-n 个数的异或等于 1-n 的异或结果, 因为 n 为奇数, 所以可以两两匹配, 计算 第 2i + 1 和 第 2(i + 1) 个数 的异或结果, 即可以求出第一个数的值, 随后遍历求后续的结果就好
 * path: https://leetcode-cn.com/problems/decode-xored-permutation/
 * level: medium
 **/
public class Question1734 {

    public int[] decode(int[] encoded) {
        int n = encoded.length + 1;
        int[] res = new int[n];

        // 计算 1到N 的异或值
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total ^= i;
        }

        // 计算数组perm下标1到n-1的异或值
        int xor = 0;
        for (int i = 1; i < n - 1; i += 2) {
            xor ^= encoded[i];
        }

        res[0] = xor ^ total;
        for (int i = 1; i < n; i++) {
            res[i] = encoded[i - 1] ^ res[i - 1];
        }

        return res;
    }

    public static void main(String[] args) {
        Question1734 q = new Question1734();
        int[] encoded = {6, 5, 4, 6};
        System.out.println(Arrays.toString(q.decode(encoded)));
    }
}
