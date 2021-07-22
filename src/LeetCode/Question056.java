package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 15:34 2019/11/4
 * description Merge Intervals 给定许多区间(eg:[1,2]), 将重复区间合并
 * note: 先对数组进行排序, 然后两两求交集
 * path: https://leetcode.com/problems/merge-intervals/description/
 * level: medium
 **/
public class Question056 {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0){
            return new int[0][];
        }
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] > o2[0]) {
                return 1;
            } else if (o1[0] == o2[0]) {
                return 0;
            } else {
                return -1;
            }
        });
        int i = 0;
        for (int j = 1; j < intervals.length; j++) {
            if (intervals[i][1] >= intervals[j][0]) {
                intervals[i][1] = Math.max(intervals[j][1], intervals[i][1]);
            }else {
                i++;
                intervals[i][0] = intervals[j][0];
                intervals[i][1] = intervals[j][1];
            }
        }
        return Arrays.copyOfRange(intervals, 0, i + 1);
    }

    public static void main(String[] args) {
        Question056 q = new Question056();
        int[][] nums = {};
        System.out.println(Arrays.deepToString(q.merge(nums)));
    }
}
