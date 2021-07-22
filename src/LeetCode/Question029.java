package LeetCode;

/**
 * @author Struggle
 * @date Created in 11:11 2019/10/25
 * description  Divide Two Integers  求两个数的除法结果  不使用乘法 除法 取余
 **/
public class Question029 {

    public int divide(int A, int B) {
        if (A == 1 << 31 && B == -1) {
            return (1 << 31) - 1;
        }
        int a = Math.abs(A), b = Math.abs(B), res = 0, x;
        //计算b的最小倍数 为了提高运算速度 以2的指数倍速度进行计算
        //<<k 左移k位 相当于乘以2的k次方
        while (a - b >= 0) {
            for (x = 0; a - (b << x << 1) >= 0; x++) {
            }
            res += 1 << x;
            a -= b << x;
        }
        return (A > 0) == (B > 0) ? res : -res;
    }

    public static void main(String[] args) {
        Question029 q = new Question029();
        System.out.println(q.divide(-10, 1));
    }
}
