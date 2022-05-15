package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:16 2022/5/15
 * description 最大三角形面积 从 n 个 点中找三个点, 返回能组成最大三角形的面积
 * node: 遍历所有情况即可
 * path: https://leetcode.cn/problems/largest-triangle-area/
 * level: easy
 **/
public class Question812 {

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    max = Math.max(max, count(points, i, j, k));
                }
            }
        }
        return max;
    }

    private double count(int[][] points, int i, int j, int k) {
        // S = (x1*y2-x1*y3+x2*y3-x2*y1+x3*y1-x3*y2) / 2
        return Math.abs(points[i][0] * points[j][1] - points[i][0] * points[k][1] + points[j][0] * points[k][1] - points[j][0] * points[i][1] + points[k][0] * points[i][1] - points[k][0] * points[j][1]) * 1.0 / 2;
    }
}
