package LeetCode;

/**
 * @author Struggle
 * @date Created in 10:12 2019/10/28
 * <p>
 * description  Majority Element  寻找数组中出现次数超过一半的数
 **/
public class Question169 {
    public int majorityElement(int[] nums) {
        int num = nums[0], k = 1;
        int i = 1;
        while (i < nums.length) {
            if (nums[i] == num) {
                k++;
            } else {
                k--;
            }
            if (k == 0) {
                num = nums[i];
                k = 1;
            }
            i++;
        }
        return num;
    }

    public static void main(String[] args) {
        Question169 q = new Question169();
        int[] nums = {8, 8, 7, 7, 7};
        System.out.println(q.majorityElement(nums));
    }
}
