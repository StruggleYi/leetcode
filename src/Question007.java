/**
 * @author Struggle
 * @date Created in 12:05 2021/6/14
 * description 整数反转  给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果  如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0
 * node:
 * path: https://leetcode-cn.com/problems/reverse-integer/
 * level:
 **/
public class Question007 {

    /**
     * 不使用 long 型的方法
     *
     * @param x
     * @return
     */
    public int reverse(int x) {
        if (x == 0) {
            return 0;
        }

        // 负数转为正数计算
        int flag = 1;
        if (x < 0) {
            flag = -1;
            x *= -1;
        }

        int res = 0;
        while (x > 0) {

            // 如果超过最大值, 直接返回0
            if (res > (Integer.MAX_VALUE - x) / 10) {
                return 0;
            }

            res = res * 10 + x % 10;
            x /= 10;
        }

        return res * flag;
    }

    public static void main(String[] args) {
        Question007 q = new Question007();
        System.out.println(q.reverse(-2147483412));
    }
}
