package LeetCode;

/**
 * @author Struggle
 * @date Created in 14:35 2021/3/27
 * description Flip String to Monotone Increasing 给定字符串s, 其只包含0或者1, 可以改变字符串中的值, 使其左边均为0, 右边均为1, 返回最少改变值的个数使得字符串满足要求, 字符串可均为0或者1
 * node:
 * path: https://leetcode.com/problems/flip-string-to-monotone-increasing/
 * level: medium
 **/
public class Question926 {

    /**
     * LeetCode 参考解法
     *   遍历的过程中维护两个参数
     *      oneCnt 1所出现的个数
     *      flips 需要翻转的次数
     * @param S 字符串S
     * @return
     */
    public int minFlipsMonoIncr(String S) {
        int oneCnt = 0;
        int flips = 0;

        for (char c : S.toCharArray()) {
            // 如果出现1, oneCnt自增
            if (c == '1') {
                oneCnt++;
            } else {
                // 如果再此之前没有出现1, 则不需要进行翻转
                if (oneCnt > 0) {
                    // 这里的思路就很重要！！！非常巧妙
                    // 这里翻转次数加1很好理解，遍历过程中前面存在1，当出现0时，必定会出现翻转的情况
                    // 这里1的个数减一不是意味着把1变成0，也可能是0变成1
                    // 举个例子： 当遍历到第k位，前面的字符串是000111时，随后出现了0000
                    //          此时第一0我们可以认为可以将其翻转为1，第二个0也可以将其翻转成1，类推到第四个时oneCnt变为0了
                    //          此时我们就应该认为此时的操作是将前面的1全部翻转为0
                    //          oneCnt为0，可以认为是前面的子串经过翻转都满足要求
                    // 总结：当出现不规则的顺序是，如果1的个数多则可以认为调整0为1，如果0的个数多的话就是调整1为0
                    //      oneCnt为0可以认为调整之后前面子串均为0
                    flips++;
                    oneCnt--;
                }
            }
        }

        return flips;
    }


    /**
     * 偏暴力解法：
     * 计算出0和1的个数, 然后进行遍历, 统计每个位置前后0和1的个数, 可以求出满足要求需要翻转的次数
     * @param S
     * @return
     */
    public int minFlipsMonoIncr2(String S) {

        // 记录字符串中0与1的个数
        int a = 0, b = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == '0') {
                a++;
            } else {
                b++;
            }
        }

        // 第i个位置前1的个数, 第i个位置后0的个数
        int m = 0;
        int n = a;
        int min = Math.min(a, b);
        for (int i = 0; i < S.length(); i++) {
            min = Math.min(min, m + n);
            if (S.charAt(i) == '0') {
                n--;
            } else {
                m++;
            }
        }
        return Math.min(min, m + n);
    }

    public static void main(String[] args) {
        Question926 q = new Question926();

        System.out.println(q.minFlipsMonoIncr("00110"));
    }
}
