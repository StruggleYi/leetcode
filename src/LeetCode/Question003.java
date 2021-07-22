package LeetCode;

/**
 * @author Struggle
 * @date Created in 16:14 2019/10/21
 * description 字符串最长不重复子串的长度
 **/
public class Question003 {
    /**
     * nums 记录字符串出现的位置, i,j分别指向当前子字符串的头和尾的位置
     */
    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        int[] nums = new int[128];
        while (j < s.length()) {
            i = Math.max(i, nums[s.charAt(j)]);
            max = Math.max(max, j - i + 1);
            nums[s.charAt(j)] = j + 1;
            j++;
        }
        return max;
    }

    public static void main(String[] args) {
        Question003 q = new Question003();
        String s = " ";
        System.out.println(q.lengthOfLongestSubstring(s));
    }
}
