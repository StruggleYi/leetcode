package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:23 2021/6/24
 * description 直线上最多的点数   给你一个数组 points ，其中 points[i] = [xi, yi] 表示 X-Y 平面上的一个点。求最多有多少个点在同一条直线上
 * node:
 * path: https://leetcode-cn.com/problems/max-points-on-a-line/
 * level: hard
 **/
public class Question149 {

    private int max = 0;

    public int maxPoints(int[][] points) {
        int len = points.length;

        if (len < 3) {
            return len;
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                int count = 0;
                for (int z = 0; z < len; z++) {
                    if (z == i || z == j || judge(points[i][0], points[i][1], points[j][0], points[j][1], points[z][0], points[z][1])) {
                        count++;
                    }
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }

    private boolean judge(int i1, int j1, int i2, int j2, int m, int n) {
        return (j2 - j1) * (i2 - m) == (i2 - i1) * (j2 - n);
    }

    public static void main(String[] args) {
        Question149 q = new Question149();
        int[][] points = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(q.maxPoints(points));
    }
}
