package LeetCode;

/**
 * @author Struggle
 * @date Created in 2025/3/30 16:42
 * description 向字符串添加空格
 * node:
 * path:
 * level: medium
 **/
public class Question2109 {

    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int k = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < spaces.length; ) {
            if (spaces[i] == k) {
                sb.append(' ');
                i++;
            }
            sb.append(chars[k]);
            k++;
        }
        for (; k < chars.length; k++) {
            sb.append(chars[k]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question2109 q = new Question2109();
        int[] spaces = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println(q.addSpaces("1234567890", spaces));
    }
}
