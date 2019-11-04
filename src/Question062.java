/**
 * @author Struggle
 * @date Created in 17:13 2019/11/4
 * description Unique Paths 一个机器人只能从往右和往下走, 从左上角走到右下角有多少种走法
 * node: 直接递归会超时, 采用一个数组记录一下情况就可以, 时间复杂度为o(mn)
 * path: https://leetcode.com/problems/unique-paths/submissions/
 * level: medium
 **/
public class Question062 {
    public int uniquePaths(int m, int n) {
        int[][] res = new int[m][n];
        res[0][0] = 1;
        for (int i = 0; i < m; i ++){
            for (int j = 0; j < n; j ++){
                if (i == 0 && j == 0){
                    continue;
                }
                if ((i == 0 && j > 0) || (j == 0 && i > 0)){
                    res[i][j] = 1;
                }else {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];
                }
            }
        }
        return res[m - 1][n - 1];
    }

    public static void main(String[] args) {
        Question062 q = new Question062();
        System.out.println(q.uniquePaths(7, 3));
    }
}
