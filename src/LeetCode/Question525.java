package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 21:20 2021/6/3
 * description 连续数组  给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度
 * node: 计算前缀和, 保存和为k的最小坐标, 如果存在0或者在此之前有值为k的前缀和存在, 那么中间那一段的和为0
 * path: https://leetcode-cn.com/problems/contiguous-array/
 * level: medium
 **/
public class Question525 {

    /**
     * 使用数组替换map 时间更少
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int len = nums.length;
        int max = 0;

        // index 用来替代map, 和为 k 的最小前缀下标为 index[k + len]
        // 由于计算的值有负数, 所以统一将其加上其数组长度即可
        // 将数组初始化为 -1, 如果数组初始化为0时, 存在数组下标为0的情况, 不好判断
        int[] index = new int[len * 2 + 1];
        Arrays.fill(index, -1);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 1) {
                count++;
            } else {
                count--;
            }

            // 如果已存在和为 count 的最小前缀下标, 则中间一段的和为0, 满足要求
            if (index[count + len] >= 0 || count == 0) {
                max = Math.max(max, i - index[count + len]);
            } else {
                index[count + len] = i;
            }
        }
        return max;
    }


    /**
     * 使用map的解法
     * @param nums
     * @return
     */
    public int findMaxLength2(int[] nums) {
        int len = nums.length;
        int max = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                count--;
            }

            if (map.containsKey(count)) {
                max = Math.max(max, i - map.get(count));
            } else {
                map.put(count, i);
            }
        }
        return max;
    }
}
