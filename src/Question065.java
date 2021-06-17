/**
 * @author Struggle
 * @date Created in 22:55 2021/6/17
 * description 有效数字  数字有效的定义为： 1、一个小数或者整数  2、（可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 整数的定义： 1、数字开头允许有 + 或者 -  2、最少含有一个数字
 * 小数的定义： 1、数字开头允许有 + 或者 -  2、至少一位数字，后面跟着一个点 3、至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字 4、一个点 '.' ，后面跟着至少一位数字
 * node:
 * path: https://leetcode-cn.com/problems/valid-number/
 * level: hard
 **/
public class Question065 {

    /**
     * 传统做法, 将e的前后进行拆分, 判断前后是否满足题目要求
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        // 将E转换成e处理
        s = s.toLowerCase();

        // 判断是否含有e
        int k = s.indexOf("e");

        // 如果不含有e, 判断字符串是否是小数或者整数
        if (k < 0) {
            if (s.charAt(0) == '+' || s.charAt(0) == '-') {
                s = s.substring(1);
            }

            return isInteger(s) || isDecimal(s);
        }

        // 如果含有多个e 或者 e 后面不含数字 或者 e 前面不含数字, 不满足要求
        if (k != s.lastIndexOf("e") || k == s.length() - 1 || k == 0) {
            return false;
        }

        String s1 = s.substring(0, k);
        String s2 = s.substring(k + 1);

        // 前面数字可以为小数或者整数
        if (s1.charAt(0) == '+' || s1.charAt(0) == '-') {
            s1 = s1.substring(1);
        }

        // 后面数字只能为整数
        if (s2.charAt(0) == '+' || s2.charAt(0) == '-') {
            s2 = s2.substring(1);
        }

        return (isInteger(s1) || isDecimal(s1)) && isInteger(s2);
    }

    /**
     * 判断字符串是否是整数
     *
     * @param s
     * @return
     */
    private boolean isInteger(String s) {

        if (s == null || s.length() == 0) {
            return false;
        }

        int i = 0;
        while (i < s.length()) {
            char a = s.charAt(i);
            if (a >= '0' && a <= '9') {
                i++;
            } else {
                return false;
            }
        }

        return true;
    }

    /**
     * 判断字符串是否是小数
     *
     * @param s
     * @return
     */
    private boolean isDecimal(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }

        int k = s.indexOf(".");
        // 不含 . 不是小数
        if (k < 0) {
            return false;
        }

        // 三种分别是 . 在最前面 最后面 中间的情况
        if (k == 0) {
            return isInteger(s.substring(1));
        } else if (k == s.length() - 1) {
            return isInteger(s.substring(0, k));
        } else {
            return isInteger(s.substring(0, k)) && isInteger(s.substring(k + 1));
        }

    }

    public static void main(String[] args) {
        Question065 q = new Question065();
        System.out.println(q.isNumber("e9"));
    }
}
