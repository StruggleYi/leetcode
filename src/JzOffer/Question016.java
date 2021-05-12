package JzOffer;

/**
 * @author Struggle
 * @date Created in 22:00 2021/5/12
 * description 数值的整数次方 实现 pow(x, n) 不使用库函数
 * node:
 * path: https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * level: medium
 **/
public class Question016 {
    /**
     * 借鉴递归方法
     */
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n < 0) {
            return 1 / (x * myPow(x, -n - 1));
        } else if (n % 2 == 1) {
            return x * myPow(x, n - 1);
        } else {
            return myPow(x * x, n / 2);
        }
    }

    /**
     * 常规递归方法
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        } else if (n > 0) {
            double k = myPow2(x, n / 2);
            if (n % 2 == 0) {
                return k * k;
            }
            return k * k * x;
        } else {
            double k = myPow2(x, n / 2);
            if (n % 2 == 0) {
                return k * k;
            }
            return k * k / x;
        }
    }

    public static void main(String[] args) {
        Question016 q = new Question016();
        System.out.println(q.myPow(2, -2));
    }
}
