package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:01 2021/5/7
 * description 数组异或操作 给你两个整数，n 和 start   数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 *                         请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * node:
 * path: https://leetcode-cn.com/problems/xor-operation-in-an-array/
 * level: easy
 **/
public class Question1486 {
    public int xorOperation(int n, int start) {
        int res = start;

        int i = 1;
        while (i < n){
            res ^= (start + 2 * i);
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Question1486 q = new Question1486();
        System.out.println(q.xorOperation(4, 3));
    }
}
