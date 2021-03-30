/**
 * @author Struggle
 * @date Created in 20:33 2021/3/30
 * description Sqrt(x) 开方, 返回整数部分的内容
 * node:
 * path: https://leetcode.com/problems/sqrtx/
 * level: easy
 **/
public class Question069 {

    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }

        if (x <= 3) {
            return 1;
        }

        return (int)Math.pow(x, 0.5);
    }

    public static void main(String[] args) {
        Question069 q = new Question069();

        System.out.println(q.mySqrt(2147395600));
    }
}
