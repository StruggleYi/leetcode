package LeetCode;

/**
 * @author Struggle
 * @date Created in 11:51 2021/7/24
 * description 替换隐藏数字得到的最晚时间  给定格式为hh:mm的时间字符串, 其中某些字符可能被 ？ 所替代, 请将其填成数字, 使得所得到的时间最大
 * node:
 * path: https://leetcode-cn.com/problems/latest-time-by-replacing-hidden-digits/
 * level: easy
 **/
public class Question1736 {

    public String maximumTime(String time) {
        char h1 = time.charAt(0);
        char h2 = time.charAt(1);
        if (h1 == '?' && h2 == '?') {
            h1 = '2';
            h2 = '3';
        } else if (h1 == '?' && h2 <= '3') {
            h1 = '2';
        } else if (h1 == '?') {
            h1 = '1';
        } else if (h2 == '?' && h1 <= '1') {
            h2 = '9';
        } else if (h2 == '?') {
            h2 = '3';
        }

        char m1 = time.charAt(3);
        char m2 = time.charAt(4);
        if (m1 == '?') {
            m1 = '5';
        }
        if (m2 == '?') {
            m2 = '9';
        }

        StringBuilder sb = new StringBuilder();
        sb.append(h1).append(h2).append(":").append(m1).append(m2);
        return sb.toString();
    }

    public static void main(String[] args) {
        Question1736 q = new Question1736();
    }
}
