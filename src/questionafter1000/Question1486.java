package questionAfter1000;

/**
 * @author Struggle
 * @date Created in 21:19 2021/1/20
 * description XOR Operation in an Array 给定数字n, start, n 代表数组的大小, start代表起始值, 数组中第i个数字的大小为 start + 2*i, 求数组中每个数字的异或值
 * node: 比较暴力的解法, 遍历求异或即可
 * path: https://leetcode.com/problems/xor-operation-in-an-array/
 * level: easy
 **/
public class Question1486 {
    public int xorOperation(int n, int start) {
        if (n == 1) {
            return start;
        }

        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= start + 2 * i;
        }

        return res;
    }

    public static void main(String[] args) {
        Question1486 q = new Question1486();
        System.out.println(q.xorOperation(1, 7));
    }
}
