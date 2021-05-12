package JzOffer;

/**
 * @author Struggle
 * @date Created in 22:14 2021/5/11
 * description 二进制中1的个数
 * node: 不能使用除2的方式, 本题中的 n 代表着无符号整形  利用 n & 1 来判断最后一位是否为1, 右移操作来进行一位一位判断, 直至数字等于0
 * path: https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * level: easy
 **/
public class Question015 {
    public int hammingWeight(int n) {
        int res = 0;

        while (n != 0) {
            res += n & 1;
            n >>>= 1;
        }

        return res;
    }

    public static void main(String[] args) {
        Question015 q = new Question015();
        System.out.println(q.hammingWeight(4));
        System.out.println();
    }
}
