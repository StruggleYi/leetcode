package LeetCode;

/**
 * @author Struggle
 * @date Created in 2025/4/3 11:23
 * description 有序三元组中的最大值
 * node:
 * path:
 * level:
 **/
public class Question2874 {

    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int len = nums.length;
        int[] max = new int[len];
        max[len - 1] = nums[len - 1];
        // 计算从i往后 的最大值 方便做三元组的乘法
        for (int i = len - 2; i >= 0; i--) {
            max[i] = Math.max(max[i + 1], nums[i]);
        }

        int t = nums[0];
        // 以 i 作为三元组的中间点 计算前面差值最大值 乘以后面的最大值
        for (int i = 1; i < len - 1; i++) {
            t = Math.max(t, nums[i]);
            ans = Math.max(ans, (long) (t - nums[i]) * max[i + 1]);
        }

        return ans;
    }

    /**
     * 借鉴思路
     * @param nums
     * @return
     */
    public long maximumTripletValue2(int[] nums) {
        int n = nums.length;
        long res = 0, imax = 0, dmax = 0;
        for (int k = 0; k < n; k++) {
            res = Math.max(res, dmax * nums[k]);
            dmax = Math.max(dmax, imax - nums[k]);
            imax = Math.max(imax, nums[k]);
        }
        return res;
    }


    public static void main(String[] args) {
        Question2874 q = new Question2874();
        System.out.println(q.maximumTripletValue(new int[]{1000000, 1, 1000000}));
    }
}
