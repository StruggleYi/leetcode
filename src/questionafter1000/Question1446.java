package questionAfter1000;

/**
 * @author Struggle
 * @date Created in 22:05 2021/3/24
 * description Consecutive Characters 求得只包含一种字符的最长非空子字符串的长度
 * node: 遍历即可
 * path: https://leetcode.com/problems/consecutive-characters/
 * level: easy
 **/
public class Question1446 {

    public int maxPower(String s) {
        if (s.length() <= 1){
            return s.length();
        }

        int max = 1;
        char a = s.charAt(0);
        int k = 1;

        for (int i = 1; i < s.length(); i++){
            if (a == s.charAt(i)){
                k++;
            }else {
                max = Math.max(k, max);
                k = 1;
                a = s.charAt(i);
            }
        }

        return Math.max(k, max);
    }

    public static void main(String[] args) {
        Question1446 q = new Question1446();

        System.out.println(q.maxPower("triplepillooooow"));
    }
}
