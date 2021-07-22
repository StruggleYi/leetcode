package LeetCode;

/**
 * @author Struggle
 * @date Created in 20:46 2021/5/13
 * description 停在原地的方案数  有一个长度为 arrLen 的数组，开始有一个指针在索引 0 处。 每一步操作中，你可以将指针向左或向右移动 1 步，或者停在原地
 * 给你两个整数 steps 和 arrLen ，请你计算并返回：在恰好执行 steps 次操作以后，指针仍然指向索引 0 处的方案数  请返回方案数 模 10^9 + 7 后的结果
 * node: (虽然代码没有别人写的这么简洁, 但是能ac并且思路没问题, 还是很开心的)
 * path: https://leetcode-cn.com/problems/number-of-ways-to-stay-in-the-same-place-after-some-steps/
 * level: hard
 **/
public class Question1269 {

    /**
     * LeetCode 借鉴答案 思路相同, 但是该写法更简洁
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays2(int steps, int arrLen) {
        arrLen = arrLen > 250 ? 251 : arrLen;
        //第i-1次 停在个数组j的位置的方案数
        int[] f1 = new int[arrLen];
        //第i-1次 停在个数组j的位置的方案数
        int[] f2 = new int[arrLen];
        f1[0] = 1;
        f1[1] = 1;
        int i = 1;
        while (i++ < steps) {
            int j = 0;
            while (j < arrLen) {
                if (j == 0) {
                    f2[j] = (f1[j] + f1[j + 1]) % 1000000007;
                } else if (j == arrLen - 1) {
                    f2[j] = (f1[j - 1] + f1[j]) % 1000000007;
                } else {
                    f2[j] = ((f1[j - 1] + f1[j]) % 1000000007 + f1[j + 1]) % 1000000007;
                }
                j++;
            }
            f1 = f2;
            f2 = new int[arrLen];
        }
        return f1[0];
    }

    /**
     * 本人暴力的做法:
     * 可以采用 dp 数组去做, 递推公式为: dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1] + dp[i + 1][j - 1]
     * 其中i 代表数组第 i 个位置, j 代表步数, 数组表示第 i 个位置走 j 步能够回到原点的方案数
     * 注意：如果直接定义dp[steps][arrLen]会内存超限, 而且通过递推公式可以发现, 每一列只与前一列相关, 所以可以简化为两列
     * 如果遍历每一列的话, 最后会超时, 因为步数远小于数组的长度, 没必要求得所有数组的位置, 这里进行剪枝
     *
     * @param steps
     * @param arrLen
     * @return
     */
    public int numWays(int steps, int arrLen) {

        long[][] dp = new long[arrLen][2];
        dp[0][0] = 1;
        for (int j = 1; j <= steps; j++) {
            for (int i = 0; i < arrLen && i < steps; i++) {
                dp[i][j % 2] = dp[i][(j + 1) % 2];
                if (i > 0) {
                    dp[i][j % 2] += dp[i - 1][(j + 1) % 2];
                }
                if (i < arrLen - 1) {
                    dp[i][j % 2] += dp[i + 1][(j + 1) % 2];
                }

                dp[i][j % 2] %= 1000000007;
                if (j == steps) {
                    break;
                }
            }
        }

        return (int) dp[0][steps % 2] % 1000000007;
    }

    public static void main(String[] args) {
        Question1269 q = new Question1269();
        System.out.println(q.numWays(27, 7));
    }
}
