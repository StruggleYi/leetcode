/**
 * @author Struggle
 * @date Created in 10:45 2019/11/4
 * description Sum of Two Integers 计算两个数的和, 不使用+和-
 * path: https://leetcode.com/problems/sum-of-two-integers/description/
 * level: easy
 **/
public class Question371 {
    /**
     *  a^b 表示a+b, a&b表示进位, 结果相加将进位左移一位, 直到进位为0即可
     */
    public int getSum(int a, int b) {
        int res, k;
        do {
            res = a ^ b;
            k = (a & b) << 1;
            a = res;
            b = k;
        }while (k != 0);
        return res;
    }

    public static void main(String[] args) {
        Question371 q = new Question371();
        System.out.println(q.getSum(10, -3));
    }
}
