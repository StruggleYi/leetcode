package LeetCode;

/**
 * @author Struggle
 * @date Created in 10:56 2019/10/23
 * description  Single Number  其他数字都出现过两次,找出只出现过一次的数字  时间复杂度o(n) 空间复杂度o(1)
 **/
public class Question136 {
    public int singleNumber(int[] nums) {
        int k = 0;
        // a^a = 0  a^0=a
        for (int i = 0; i < nums.length; i++) {
            k ^= nums[i];
        }
        return k;
    }

    public static void main(String[] args) {
        Question136 q = new Question136();
        int[] nums = {2, 2, 1};
        System.out.println(q.singleNumber(nums));
    }
}
