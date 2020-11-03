import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 17:13 2020/11/4
 * description Insert Interval 有一组区间的范围，给定一个区间，将该区间插入到现有的区间道中
 * node: 区间插入，注意临界值判断
 * path: https://leetcode.com/problems/insert-interval/
 * level: medium
 **/
public class Question057 {

    /**
     * 该解法思路在于对每个区间进行比对，如果能够插入，更新要插入区间的范围
     * 如果不能插入，则将就区间略过，有相切、相交、相离、包含 四种关系
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int a = newInterval[0];
        int b = newInterval[1];
        // 用k记录最后结果的个数
        int k = 0;
        int[][] res = new int[intervals.length + 1][2];
        for (int i = 0; i < intervals.length; i++) {
            int m = intervals[i][0];
            int n = intervals[i][1];
            // 如果要插入的区间的右值小于当前读取区间的左值，则直接复制后面区间的值，然后将要插入区间的值插到当前位置
            if (b < m) {
                // i是当前读取区间的位置，也就是要复制的起始点
                // k + 1是新区间要插入的起始位置
                // intervals.length - i 是剩余要复制区间的个数
                // 左相离
                System.arraycopy(intervals, i, res, k + 1, intervals.length - i);
                res[k][0] = a;
                res[k][1] = b;
                k += intervals.length -i;
                return Arrays.copyOf(res, k + 1);
            } else if (m <= a && n >= b) {
                // 包含的关系
                // 这里也可以进行优化， 直接复制后面的区间即可
                a = m;
                b = n;
            } else if (n < a) {
                // 右相离
                res[k][0] = m;
                res[k++][1] = n;
            } else if (b >= m && b <= n) {
                // 左相交
                b = n;
            } else if (a >= m && a <= n) {
                // 右相交
                a = m;
            }
        }
        res[k][0] = a;
        res[k++][1] = b;
        return Arrays.copyOf(res, k);
    }

    public static void main(String[] args) {
        Question057 q = new Question057();
        int[][] nums = {{1, 3}, {6, 9}};
        System.out.println(Arrays.deepToString(q.insert(nums, new int[]{2, 8})));
    }
}
