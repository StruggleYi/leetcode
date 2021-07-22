package LeetCode;

/**
 * @author Struggle
 * @date Created in 12:46 2021/3/26
 * description Max Difference You Can Get From Changing an Integer  改变一串数字中的数字i，将其变为k, 使得获取新的整数m, 重复两次操作获得m, n, 返回m 与 n差值的最大值, 其中数字的首位不可改为0
 * node:
 * path: https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer/
 * level: medium
 **/
public class Question1432 {

    /**
     * 思路：
     * 最大值：找到第一个不是9的数字,将其转为9
     * 最小值：如果第一位不是1, 将其变为1; 如果第一位是1, 找出第一个大于1的数字, 将其变为0
     *
     * @param num
     * @return
     */
    public int maxDiff(int num) {
        if (num < 10) {
            return 8;
        }
        String s = Integer.toString(num);

        char m = ' ';

        //找到第一个不是9的字符
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch != '9') {
                m = ch;
                break;
            }
        }
        int max = Integer.parseInt(s.replace(m, '9'));
        int min;

        // 如果第一位不是1，将其所有与之相同的数字转为1
        if (s.charAt(0) != '1'){
            min = Integer.parseInt(s.replace(s.charAt(0), '1'));
        }else {
            int i = 1;
            // 第一位是1的话，找到第一个大于1的数字将其转为0
            while (i < s.length()){
                if (s.charAt(i) > '1'){
                    break;
                }
                i++;
            }

            if (i == s.length()){
                min = Integer.parseInt(s);
            }else {
                min = Integer.parseInt(s.replace(s.charAt(i), '0'));
            }
        }

        return max - min;
    }

    public static void main(String[] args) {
        Question1432 q = new Question1432();
        System.out.println(q.maxDiff(555));
    }
}
