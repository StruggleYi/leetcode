package LeetCode;

/**
 * @author Struggle
 * @date Created in 10:19 2019/10/23
 * description  Valid Palindrome  判断字符串是否回文, 忽略符号与大小写, 只关注数字和字母
 **/
public class Question125 {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int i = 0, j = s.length() - 1;
        while (i < j){
            while (i < j){
                if((s.charAt(i)>='a' && s.charAt(i)<='z') || (s.charAt(i)>='0' && s.charAt(i)<='9')){
                    break;
                }
                i++;
            }
            while (i < j){
                if((s.charAt(j)>='a' && s.charAt(j)<='z') || (s.charAt(j)>='0' && s.charAt(j)<='9')){
                    break;
                }
                j--;
            }
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Question125 q = new Question125();
        String s = "A man, a plan, a canal: Panama";
        System.out.println(q.isPalindrome(s));
    }
}
