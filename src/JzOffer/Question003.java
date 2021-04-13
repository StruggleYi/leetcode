package JzOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 21:14 2021/4/13
 * description 数组中重复的数字  返回数组中任意出现的重复数字
 * node:
 * path: https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * level:
 **/
public class Question003 {

    /**
     * 借鉴解法: 原地置换法, 值 k 只能出现在第 k 个位置, 如果 k 值不在第 k 个位置且该位置上的值为 k, 说明值重复
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            while (nums[i]!=i){
                if(nums[i]==nums[nums[i]]){
                    return nums[i];
                }
                temp=nums[i];
                nums[i]=nums[temp];
                nums[temp]=temp;
            }
        }
        return -1;
    }

    /**
     * 通过数组判断值有没有重复
     * @param nums
     * @return
     */
    public int findRepeatNumber3(int[] nums) {
        int[] arrays = new int[100001];

        for (int k : nums) {
            if (arrays[k] == 1) {
                return k;
            }
            arrays[k] = 1;
        }

        return -1;
    }

    /**
     * 通过Set判断值有没有重复, 时间开销比数组更高
     * @param nums
     * @return
     */
    public int findRepeatNumber2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int k : nums) {
            if (set.contains(k)) {
                return k;
            }
            set.add(k);
        }

        return -1;
    }

    public static void main(String[] args) {
        Question003 q = new Question003();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(q.findRepeatNumber(nums));
    }
}
