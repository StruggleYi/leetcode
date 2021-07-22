package LeetCode;

/**
 * @author Struggle
 * @date Created in 17:05 2019/10/25
 * description  Longest Valid Parentheses  最长符合括号匹配的子字符串长度
 **/
public class Question032 {
    public int longestValidParentheses(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int max = 0;
        int left = 0, right = 0;
        // 从左到右遍历一遍,以左括号为基准,寻找最长的匹配字符串长度
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            }
            if (left < right) {
                left = right = 0;
            }
        }
        left = right = 0;
        // 从右到左遍历一遍,以右括号为基准,寻找最长的匹配字符串长度
        for (int i = s.length() - 1; i >=0; i--) {
            if (s.charAt(i) == '(') {
                left++;
            } else {
                right++;
            }
            if (left == right) {
                max = Math.max(max, left + right);
            }
            if (left > right) {
                left = right = 0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Question032 q = new Question032();
        String s = "(()";
        System.out.println(q.longestValidParentheses(s));
    }
}
