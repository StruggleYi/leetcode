package LeetCode;

/**
 * @author Struggle
 * @date Created in 12:22 2021/3/28
 * description Generate a String With Characters That Have Odd Counts 给定一个字符串长度n, 返回一个满足要求的字符串, 其中每个字符出现的次数为奇数
 * node:
 * path: https://leetcode.com/problems/generate-a-string-with-characters-that-have-odd-counts/
 * level: easy
 **/
public class Question1374 {
    public String generateTheString(int n) {

        StringBuilder s = new StringBuilder();

        // 先用ab将其填满, 如果n为奇数则缺少一个数
        for (int i = 0; i < n / 2; i++){
            s.append("ab");
        }
        // 如果n能被4整除, 则说明a和b的个数是偶数, 都去掉一个ab将其用cd代替
        if (n / 2 % 2 == 0 && n > 1){
            s.replace(0, 2, "cd");
        }

        // 如果n的奇数, 在上述计算过程中会缺少一个字符, 用e代替即可
        if (n % 2 != 0){
            s.append("e");
        }

        return s.toString();
    }

    public static void main(String[] args) {
        Question1374 q = new Question1374();
        System.out.println(q.generateTheString(4));
    }
}
