/**
 * @author Struggle
 * @date Created in 15:17 2019/10/21
 * description 数组最大连续子数组和 时间复杂度 o(n)
 **/
public class Question53 {

    public int maxSubArray(int[] nums) {
        int temp = nums[0], i = 0;
        int max = temp;
        while (++i < nums.length) {
            temp = temp < 0 ? nums[i] : temp + nums[i];
            max = max > temp ? max : temp;
        }
        return max;
    }

    public static void main(String[] args) {
        Question53 q = new Question53();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(q.maxSubArray(nums));
    }
}
