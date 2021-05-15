/**
 * @author Struggle
 * @date Created in 22:51 2021/5/15
 * description 整数转罗马数字
 * node:
 * path: https://leetcode-cn.com/problems/integer-to-roman/
 * level: easy
 **/
public class Question012 {

    public String intToRoman(int num) {
        // 定义输出字符串
        StringBuilder str = new StringBuilder();

        //循环储存字符
        while (num > 0) {
            if (num >= 1000) {
                str.append("M");
                num = num - 1000;
            } else if (num >= 900) {
                str.append("CM");
                num = num - 900;
            } else if (num >= 500) {
                str.append("D");
                num = num - 500;
            } else if (num >= 400) {
                str.append("CD");
                num = num - 400;
            } else if (num >= 100) {
                str.append("C");
                num = num - 100;
            } else if (num >= 90) {
                str.append("XC");
                num = num - 90;
            } else if (num >= 50) {
                str.append("L");
                num = num - 50;
            } else if (num >= 40) {
                str.append("XL");
                num = num - 40;
            } else if (num >= 10) {
                str.append("X");
                num = num - 10;
            } else if (num >= 9) {
                str.append("IX");
                num = num - 9;
            } else if (num >= 5) {
                str.append("V");
                num = num - 5;
            } else if (num >= 4) {
                str.append("IV");
                num = num - 4;
            } else if (num >= 1) {
                str.append("I");
                num = num - 1;
            }
        }
        return str.toString();
    }
}
