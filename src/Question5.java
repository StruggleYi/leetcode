/**
 * @author Struggle
 * @date Created in 10:47 2019/10/22
 * description 求给定字符串s 的最长回文子串
 **/
public class Question5 {

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) {
            return s;
        }
        if (length == 2) {
            return s.charAt(0) == s.charAt(1) ? s : s.charAt(0) + "";
        }
        char[] cArray = s.toCharArray();
        if (isPalindromic(0, length - 1, cArray)) {
            return s;
        }

        int max = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            if (isPalindromic(i - max - 1, i, cArray)) {
                start = i - max - 1;
                max = max + 2;
            } else if (isPalindromic(i - max, i, cArray)) {
                start = i - max;
                max = max + 1;
            }
        }
        return new String(cArray, start, max);
    }

    //判断是否是回文字符串
    private boolean isPalindromic(int left, int right, char[] charArray) {
        if (left < 0) {
            return false;
        }
        while (left < right) {
            if (charArray[left++] != charArray[right--]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question5 q = new Question5();

        String s = "cbbd";
        System.out.println(q.longestPalindrome(s));
    }
}
