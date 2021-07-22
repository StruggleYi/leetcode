package LeetCode;

/**
 * @author Struggle
 * @date Created in 14:54 2019/10/21
 * description : 数组去重, 空间复杂度 o(1)
 **/
public class Question026 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = i + 1;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
            } else {
                nums[++i] = nums[j++];
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        Question026 q = new Question026();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(q.removeDuplicates(nums));
    }
}
