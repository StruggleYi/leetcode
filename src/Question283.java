import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 16:38 2019/10/31
 * description Move Zeroes  把数组中的0全部移到数组末尾, 不改变数组其他数字的相对位置
 * note: 计算出0的个数, 把其他数字往前移动, 最后补0即可
 * path: https://leetcode.com/problems/move-zeroes/description/
 * level: easy
 **/
public class Question283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                nums[i - count] = nums[i];
            }
        }
        while (count-- > 0) {
            nums[nums.length - 1 - count] = 0;
        }
    }

    public static void main(String[] args) {
        Question283 q = new Question283();
        int[] nums = {0, 1, 0, 3, 12};
        q.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
