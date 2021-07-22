package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 16:00 2019/10/31
 * description  Longest Consecutive Sequence 给定一组未排序的数组, 求出数组中最长连续序列的长度  时间复杂度0(n)
 * 思路： 用一个set来保存数字, 然后从头开始遍历数组, 若当前数字为k, 判断是否存在k-1, 若不存在k-1, 则计算以k为起点的连续数字的个数
 *       目的是为了减少重复计算的量, 提高运算的时间
 * path: https://leetcode.com/problems/longest-consecutive-sequence/
 * level: hard
 **/
public class Question128 {
    public int longestConsecutive(int[] nums) {
        int max = 0;
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            set.add(k);
        }
        for (int num : nums) {
            int count = 1;
            if (!set.contains(num - 1)) {
                while (set.contains(++num)) {
                    count++;
                }
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        Question128 q = new Question128();
        int[] nums = {1, 2, 0, 1};
        System.out.println(q.longestConsecutive(nums));
    }
}
