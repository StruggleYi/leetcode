package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 23:25 2021/8/7
 * description 环形数组是否存在循环
 * node:
 * path: https://leetcode-cn.com/problems/circular-array-loop/
 * level: medium
 **/
public class Question457 {
    public boolean circularArrayLoop(int[] nums) {
        int[] flag = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == 0 && judge(nums, i, flag)) {
                return true;
            }
        }

        return false;
    }

    private boolean judge(int[] nums, int i, int[] flag) {
        List<Integer> list = new ArrayList<>();

        flag[i] = 1;
        while (list.indexOf(i) < 0) {
            list.add(i);
            i += nums[i] + nums.length * 1000;
            i %= nums.length;
            flag[i] = 1;
        }

        int k = list.indexOf(i);
        if (list.size() - k < 2) {
            return false;
        }

        boolean flag1 = false;
        boolean flag2 = false;
        for (int j = k; j < list.size(); j++) {
            int integer = list.get(j);
            if (nums[integer] > 0) {
                flag1 = true;
            } else if (nums[integer] < 0) {
                flag2 = true;
            }
        }

        return !(flag1 && flag2);
    }
}
