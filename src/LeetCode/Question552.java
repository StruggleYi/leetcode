package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:39 2021/8/18
 * description  学生出勤记录 II  给你一个整数 n ，表示出勤记录的长度（次数）。请你返回记录长度为 n 时，可能获得出勤奖励的记录情况 数量
 * node:
 * path: https://leetcode-cn.com/problems/student-attendance-record-ii/
 * level: hard
 **/
public class Question552 {
    int N = 6;
    int mod = (int)1e9+7;
    long[][] mul(long[][] a, long[][] b) {
        int r = a.length, c = b[0].length, z = b.length;
        long[][] ans = new long[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < z; k++) {
                    ans[i][j] += a[i][k] * b[k][j];
                    ans[i][j] %= mod;
                }
            }
        }
        return ans;
    }
    public int checkRecord(int n) {
        long[][] ans = new long[][]{
                {1}, {0}, {0}, {0}, {0}, {0}
        };
        long[][] mat = new long[][]{
                {1, 1, 1, 0, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0}
        };
        while (n != 0) {
            if ((n & 1) != 0) ans = mul(mat, ans);
            mat = mul(mat, mat);
            n >>= 1;
        }
        int res = 0;
        for (int i = 0; i < N; i++) {
            res += ans[i][0];
            res %= mod;
        }
        return res;
    }
}
