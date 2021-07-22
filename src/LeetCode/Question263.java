package LeetCode;

/**
 * @author Struggle
 * @date Created in 16:21 2019/10/31
 * description Ugly Number 判断一个数是否是丑数(因子只包含2,3,5)
 * 注： 非正数均不为丑数, 1是特殊的丑数
 *
 * path: https://leetcode.com/problems/ugly-number/description/
 * level: easy
 **/
public class Question263 {
    /**
     * 递归做法
     */
    public boolean isUgly(int num) {
        if (num == 1) {
            return true;
        }
        if (num <= 0) {
            return false;
        }
        if (num % 2 == 0) {
            return isUgly(num / 2);
        } else if (num % 3 == 0) {
            return isUgly(num / 3);
        } else if (num % 5 == 0) {
            return isUgly(num / 5);
        }
        return false;
    }

    /**
     * 非递归做法
     */
    public boolean isUgly2(int num) {
        for (int i = 2; i < 6 && num > 0; i++) {
            while (num % i == 0) {
                num /= i;
            }
        }
        return num == 1;
    }

    public static void main(String[] args) {
        Question263 q = new Question263();
        System.out.println(q.isUgly(14));
    }
}
