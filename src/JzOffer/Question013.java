package JzOffer;

/**
 * @author Struggle
 * @date Created in 23:23 2021/5/8
 * description 机器人的运动范围 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子
 * node: 依次向下和向右进行递归计算, 记录已经走过的位置, 避免重复计算即可
 * path: https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * level: medium
 **/
public class Question013 {

    int max = 0;

    public int movingCount(int m, int n, int k) {
        boolean[][] flag = new boolean[m][n];
        dps(m, n, 0, 0, k, flag);
        return max;
    }

    private void dps(int m, int n, int i, int j, int k, boolean[][] flag) {
        if (i >= m || j >= n || flag[i][j]) {
            return;
        }

        if (count(i) + count(j) > k) {
            return;
        }

        flag[i][j] = true;
        max++;

        //可以简化为向右和向下搜索
        dps(m, n, i, j + 1, k, flag);
        dps(m, n, i + 1, j, k, flag);
    }

    private int count(int x) {
        if (x == 100) {
            return 1;
        }
        if (x <= 9) {
            return x;
        }
        return x / 10 + x % 10;
    }

    public static void main(String[] args) {
        Question013 q = new Question013();
        System.out.println(q.movingCount(39, 40, 17));
    }
}
