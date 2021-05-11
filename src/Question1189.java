/**
 * @author Struggle
 * @date Created in 20:49 2021/1/20
 * description Maximum Number of Balloons 给定一个字符串, 将其进行重组, 输出能够组成 balloon 的最大个数, 每个位置上的字符最多只能用一次
 * node: 分别统计几个字符出现的次数, 取最小值即可
 * path: https://leetcode.com/problems/maximum-number-of-balloons/
 * level: easy
 **/
public class Question1189 {
    public int maxNumberOfBalloons(String text) {
        if (text == null || text.length() < 7) {
            return 0;
        }

        int[] num = new int[26];

        for (int i = 0; i < text.length(); i++) {
            int k = text.charAt(i) - 'a';
            num[k]++;
        }

        int min = Integer.MAX_VALUE;

        String s = "balloon";
        for (int i = 0; i < s.length(); i++) {
            int k = s.charAt(i) - 'a';
            // l 和 o 一个字符串出现了两次
            if (k == 14 || k == 11) {
                min = Math.min(min, num[k] / 2);
            } else {
                min = Math.min(min, num[k]);
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Question1189 q = new Question1189();
        System.out.println(q.maxNumberOfBalloons("leetcode"));
    }
}
