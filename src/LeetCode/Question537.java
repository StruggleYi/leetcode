package LeetCode;

/**
 * @author Struggle
 * @date Created in 14:26 2021/3/27
 * description Complex Number Multiplication 虚数相乘, 返回计算结果 给定的虚数格式： 1+-1i, i*i = -1
 * node: 分解出虚数部分和实数部分即可
 * path: https://leetcode.com/problems/complex-number-multiplication/
 * level: medium
 **/
public class Question537 {
    public String complexNumberMultiply(String a, String b) {
        String[] split = a.split("\\+");
        int a1 = Integer.valueOf(split[0]);
        int b1 = Integer.valueOf(split[1].substring(0, split[1].length() - 1));

        split = b.split("\\+");
        int a2 = Integer.valueOf(split[0]);
        int b2 = Integer.valueOf(split[1].substring(0, split[1].length() - 1));

        int m = a1 * a2 - b1 * b2;
        int n = a1 * b2 + a2 * b1;
        return m + "+" + n + "i";
    }

    public static void main(String[] args) {
        Question537 q = new Question537();

        System.out.println(q.complexNumberMultiply("1+-1i", "1+-1i"));
    }
}
