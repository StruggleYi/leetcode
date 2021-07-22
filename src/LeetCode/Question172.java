package LeetCode;

/**
 * @author Struggle
 * @date Created in 9:54 2019/10/25
 * description Factorial Trailing Zeroes  求得n!中0的个数
 **/
public class Question172 {

    /** 由于2的个数大于5的个数
     *  此题转换为计算1到n中5的个数
     *  eg  n = 30
     *  n / 5 的意思为 将1-30进行整除,可以得到1-6,表示从1-30中已经分解出6个5
     *  分别为 5 10 15 20 25 30 这些数字都分解除5的结果为1 2 3 4 5 6
     *  继续递归计算1-6中是否有数字可以分解出5
     */
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main(String[] args) {
        Question172 q = new Question172();
        System.out.println(q.trailingZeroes(1808548329));
    }
}
