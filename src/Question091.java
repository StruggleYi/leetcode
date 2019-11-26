/**
 * @author Struggle
 * @date Created in 14:50 2019/11/26
 * description Decode Ways 给定一个数字字符串, 其中字母A-Z分别对应数字1-26, 输出数字字符串可能对应的不同字母串的个数. (有多少种字母的字符串可以转化为该数字字符串)
 * note: 使用dp[i] 记录当前到第i个字符能够解码的个数即可.
 * path: https://leetcode.com/problems/decode-ways/description/
 * level: medium
 **/
public class Question091 {

    public int numDecodings(String s) {
        int[] res = new int[s.length() + 1];
        char[] chars = s.toCharArray();
        if (chars[0] == '0') {
            return 0;
        }

        res[0] = 1;
        res[1] = 1;
        if (s.length() == 1) {
            return res[1];
        }

        // 注： res 递归数组中的指向i 与 chars数组中指向的i 不一致
        // res中的起始下标相当于是0 而res 递归数组由于考虑到递归, 多利用了一位
        // 所以i 表示第i 个元素, 所以两个数组相隔1位
        int i = 1;
        while (i < s.length()) {
            // 00 表示不存在解码的情况
            if (chars[i - 1] == '0' && chars[i] == '0') {
                return 0;
            }
            // 01-09 则表示与i 指向0的值相同
            // eg: ...101 则与...10的个数相同
            else if (chars[i - 1] == '0') {
                res[i + 1] = res[i - 1];
            }
            // 20、30 ... 90 表示不存在解码情况
            else if (chars[i] == '0' && chars[i - 1] > '2') {
                return 0;
            }
            // 10、20 表示与10、20 前面的数字解码个数相同
            // eg: ...110 则与 ...1 的个数相同
            else if (chars[i] == '0') {
                res[i + 1] = res[i - 1];
            }
            // 小于等于26的情况, 这里已经去除了0-10、20的情况, 这些数字可以拆开与整体两种方式
            // eg: 12 这里可以有1 2 与12 两种处理方式
            else if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26){
                res[i + 1] = res[i - 1] + res[i];
            }
            // 剩余的大于26的数字, 只能当做两个分开的数字来解码, 只有一种情况
            else {
                res[i + 1] = res[i];
            }
            i++;
        }
        return res[i];
    }

    public static void main(String[] args) {
        Question091 q = new Question091();
        String s = "231";
        System.out.println(q.numDecodings(s));
    }
}
