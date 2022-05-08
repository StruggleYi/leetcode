package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 17:21 2022/5/8
 * description 数组中重复的数据
 * node: 交换数组位置或者用负数表示某个值在对应位置已经出现过一次, 当再次看到该值时, 将其加入到结果集
 * path: https://leetcode-cn.com/problems/find-all-duplicates-in-an-array/
 * level: medium
 **/
public class Question442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; ) {
            int k = nums[i];
            if (k - 1 != i) {
                if (nums[k - 1] == k) {
                    res.add(k);
                    nums[i] = -1;
                    i++;
                } else if (nums[k - 1] == -1) {
                    nums[k - 1] = k;
                    nums[i] = -1;
                    i++;
                } else {
                    change(nums, i, k - 1);
                }
            } else {
                i++;
            }
        }

        return res;
    }

    private void change(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        Question442 q = new Question442();
        int[] nums = {3, 11, 8, 16, 4, 15, 4, 17, 14, 14, 6, 6, 2, 8, 3, 12, 15, 20, 20, 5};
        System.out.println(q.findDuplicates(nums).toString());
    }
}
