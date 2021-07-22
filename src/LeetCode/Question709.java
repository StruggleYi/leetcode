package LeetCode;

/**
 * @author Struggle
 * @date Created in 2020/11/4 10:02
 * description To Lower Case 字符串全部转为小写
 * path: https://leetcode.com/problems/to-lower-case/
 * level: easy
 **/
public class Question709 {
    public String toLowerCase(String str) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            char a = str.charAt(i);
            if (a >= 65 && a <= 90) {
                a += 32;
            }
            sb.append(a);
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question709 q = new Question709();
        System.out.println(q.toLowerCase(""));
    }
}
