package LeetCode;

/**
 * @author Struggle
 * @date Created in 2025/4/13 22:23
 * description 统计好数字的个数
 * node: 其实啥计算一个比较大的数字的次方
 * level: medium
 **/
public class Question1922 {

    public static int MOD = 1000000007;

    public int countGoodNumbers(long n) {
        if (n == 1) {
            return 5;
        }

        // 确保 n 为偶数
        if (n % 2 == 0) {
            return (int) (count(n) % MOD);
        }

        return (int) (5 * count(n - 1) % MOD);
    }

    private long count(long n) {
        // n为偶数
        long k = n / 2;
        // 递归计算 20的k次方
        return dp(k) % MOD;
    }

    private long dp(long n) {
        if (n == 1) {
            return 20;
        }

        long res = dp(n / 2) % MOD;
        if (n % 2 == 0) {
            return res * res % MOD;
        }
        return (20 * res % MOD * res % MOD);
    }

    public static void main(String[] args) {
        Question1922 q = new Question1922();
        System.out.println(q.countGoodNumbers(12345674635124L));
        System.out.println(q.countGoodNumbers(8));

    }
}
