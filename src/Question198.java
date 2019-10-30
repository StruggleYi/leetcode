/**
 * @author Struggle
 * @date Created in 11:00 2019/10/30
 * description  House Robber  盗贼最多能偷多少东西(不能偷隔壁两家)
 **/
public class Question198 {

    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        } else if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }else if (nums.length == 0){
            return 0;
        }

        int n = nums.length;
        int[] val = new int[n];
        val[0] = nums[0];
        val[1] = Math.max(nums[0], nums[1]);
        int i = 2;
        while (i < n) {
            val[i] = Math.max(val[i - 1], val[i - 2] + nums[i]);
            i++;
        }
        return val[n - 1];
    }


    public static void main(String[] args) {
        Question198 q = new Question198();
        int[] nums = {114, 117, 207, 117, 235, 82, 90, 67, 143, 146, 53, 108, 200, 91, 80, 223, 58, 170, 110, 236, 81, 90, 222, 160, 165, 195, 187, 199, 114, 235, 197, 187, 69, 129, 64, 214, 228, 78, 188, 67, 205, 94, 205, 169, 241, 202, 144, 240};
        System.out.println(q.rob(nums));
    }
}
