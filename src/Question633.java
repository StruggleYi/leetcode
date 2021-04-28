/**
 * @author Struggle
 * @date Created in 20:04 2021/4/28
 * description 平方数之和  给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 * node: 常规思路: 1、暴力解法; 2、左右指针;
 *               3、数学规律：奇质数能表示为两个平方数之和的充分必要条件是该质数被 4 除余 1
 *                  当且仅当一个自然数的质因数分解中，满足 4k+3 形式的质数次方数均为偶数时，该自然数才能被表示为两个平方数之和
 * path: https://leetcode-cn.com/problems/sum-of-square-numbers/
 * level: medium
 **/
public class Question633 {

    /**
     * 官方解法 https://leetcode-cn.com/problems/sum-of-square-numbers/solution/ping-fang-shu-zhi-he-by-leetcode-solutio-8ydl/
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        for (int base = 2; base * base <= c; base++) {
            // 如果不是因子，枚举下一个
            if (c % base != 0) {
                continue;
            }

            // 计算 base 的幂
            int exp = 0;
            while (c % base == 0) {
                c /= base;
                exp++;
            }

            // 根据 Sum of two squares theorem 验证
            if (base % 4 == 3 && exp % 2 != 0) {
                return false;
            }
        }

        // 例如 11 这样的用例，由于上面的 for 循环里 base * base <= c ，base == 11 的时候不会进入循环体
        // 因此在退出循环以后需要再做一次判断
        return c % 4 != 3;
    }


    /**
     * 双指针解法
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum2(int c) {
        int left = 0;
        int right = (int) Math.sqrt(c);

        while (left <= right) {
            long sum = left * left + right * right;

            if (sum == c) {
                return true;
            } else if (sum > c) {
                right--;
            } else {
                left++;
            }
        }
        return false;
    }

    /**
     * 暴力解法
     *
     * @param c
     * @return
     */
    public boolean judgeSquareSum3(int c) {
        int k = (int) Math.pow(c, 0.5);
        if (k * k == c) {
            return true;
        }

        while (k * k >= c / 2) {
            int m = (int) Math.pow(c - k * k, 0.5);
            if (m * m == c - k * k) {
                return true;
            }
            k--;
        }
        return false;
    }

    public static void main(String[] args) {
        Question633 q = new Question633();
        System.out.println(q.judgeSquareSum2(11));
    }
}
