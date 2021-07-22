package LeetCode;

/**
 * @author Struggle
 * @date Created in 14:57 2019/11/4
 * description Jump Game 给定一组非负的数字, 数字代表最大跳跃的步数, 判断能否成功到达最后一格
 * path:  https://leetcode.com/problems/jump-game/description/
 * level: medium
 **/
public class Question055 {
    /**
     * 个人做法, 采用数组统计哪些位置能够访问
     * 遍历数组, 即可统计出是否可以访问到最后一个位置
     * 时间复杂度偏高
     */
    public boolean canJump(int[] nums) {
        boolean[] flag = new boolean[nums.length];
        flag[0] = true;
        // 这里加一个判断, 看是否能到i位置
        for (int i = 0; i < nums.length && flag[i]; i++) {
            int k = nums[i];
            int j = i;
            while (j <= i + k && j < nums.length) {
                flag[j++] = true;
            }
            if (flag[nums.length - 1]) {
                return true;
            }
        }
        return flag[nums.length - 1];
    }

    /**
     * 方法一参照方法二思路进行更新, 去掉用来记录能到达位置的数组, 直接记录能够到达的最远的位置
     */
    public boolean canJump3(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length && i <= max; i++) {
            if (i + nums[i] >= max){
                max = i + nums[i];
            }
        }
        return max >= nums.length - 1;
    }

    /**
     * 参考的简易做法：直接从最后一个节点出发, 往前推算
     * lastPos 用来记录当前能够到达的节点位置
     * i + nums[i] >= lastPost 则说明从i节点出发可以到达lastPos位置, 更新位置i
     * 看最终能否到达起点0, 相比于上面解法, 减少了遍历记录能够到达的点的重复过程
     */
    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = lastPos - 1; i >= 0; i--) {
            if ((i + nums[i]) >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


    public static void main(String[] args) {
        Question055 q = new Question055();
        int[] nums = {2, 0};
        System.out.println(q.canJump3(nums));
    }
}
