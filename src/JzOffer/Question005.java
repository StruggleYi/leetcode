package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:13 2021/4/25
 * description 空格替换
 * node: 遍历即可
 * path: https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * level: easy
 **/
public class Question005 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();

        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
            i++;
        }

        return sb.toString();
    }
}
