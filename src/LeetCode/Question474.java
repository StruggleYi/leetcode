package LeetCode;

/**
 * @author Struggle
 * @date Created in 0:05 2021/6/6
 * description 一和零  给你一个二进制字符串数组 strs 和两个整数 m 和 n  请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1
 * node:
 * path: https://leetcode-cn.com/problems/ones-and-zeroes/
 * level: medium
 **/
public class Question474 {

    /**
     * LeetCode 只用二层dp解法, 时间更快, 减去了很多三层递归没必要的计算过程
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] counts = new int[strs.length][2];
        int count0, count1, sum0 = 0, sum1 = 0;
        String str;
        for (int i = 0; i < strs.length; ++i) {
            str = strs[i];
            count0 = 0;
            count1 = 0;
            for (int j = 0; j < str.length(); ++j) {
                if (str.charAt(j) == '0') {
                    ++count0;
                }else {
                    ++count1;
                }
            }
            counts[i][0] = count0;
            counts[i][1] = count1;
            sum0 += count0;
            sum1 += count1;
        }
        // 这里的目的是遍历更少的次数, 因为列中如果没有这么多1或者0, 取最大的m, n也没有意义
        m = Math.min(m, sum0);
        n = Math.min(n, sum1);
        int[][] dp = new int[m + 1][n + 1];
        for (int k = 0; k < counts.length; ++k) {
            count0 = counts[k][0];
            count1 = counts[k][1];

            // 遍历每个能选择第k个字符串的dp, 更新最新的大小值
            for (int i = m; i - count0 >= 0; --i) {
                for (int j = n; j - count1 >= 0; --j) {
                    // 这里i,j并不关心之前的i - count0, j - count1是如何选择前面的子集
                    // 我们只需要知道i - count0, j - count1下, 最大子集的个数是多少即可
                    // 在此基础上, 去更新i, j的最大值
                    dp[i][j] = Math.max(dp[i][j], dp[i - count0][j - count1] + 1);
                }
            }
        }
        return dp[m][n];
    }

    /**
     * 基本动态规划思想
     *  dp[i][j][k] 用来记录第i个字符串 0的个数j 1个个数k 的最大子集的大小
     *  如果使用递归的话, 会重复计算很多无用值, 用于中间变量计算
     * @param strs
     * @param m
     * @param n
     * @return
     */
    public int findMaxForm2(String[] strs, int m, int n) {

        int len = strs.length;
        int[] one = new int[len];
        int[] zero = new int[len];

        for (int i = 0; i < len; i++) {
            int k = numOfOne(strs[i]);
            one[i] = k;
            zero[i] = strs[i].length() - k;
        }

        int[][][] dp = new int[len + 1][m + 1][n + 1];

        // 为了避免i-1小于0的情况, 这里从1开始
        for (int i = 1; i <= len; i++) {
            // j 代表0的个数, k 代表1的个数
            // 分别遍历计算0与1不同个数的情况下的最大子集数
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= n; k++) {

                    // 初始值为不选择第i个字符串, 则该值最小与i-1下的j,k 值相同
                    dp[i][j][k] = dp[i - 1][j][k];

                    // 如果可以选择该字符串, 则最大子串值为取或者不取该子串
                    if (j >= zero[i - 1] && k >= one[i - 1]) {
                        dp[i][j][k] = Math.max(dp[i][j][k], dp[i - 1][j - zero[i - 1]][k - one[i - 1]] + 1);
                    }

                }
            }
        }

        return dp[len][m][n];
    }

    private int numOfOne(String s) {
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            if (s.charAt(i) == '1') {
                count++;
            }
            i++;
        }
        return count;
    }


    public static void main(String[] args) {
        Question474 q = new Question474();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        System.out.println(q.findMaxForm(strs, 5, 5));
    }
}
