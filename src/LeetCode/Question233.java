package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:32 2021/8/13
 * description 数字 1 的个数
 * node:
 * path: https://leetcode-cn.com/problems/number-of-digit-one/
 * level: hard
 **/
public class Question233 {
    /**
     * 本题个人思路记录： 本质上还是找规律的题目，如果使用暴力法去数的话，肯定是超时的
     * 我的思路在于按不同位数将数字进行拆分计算，原理如下：
     * 18 可以看做首位 为 0 或者 1 时 所出现的 1 的次数, 很明显 首位为 0 时看后面几位 0 出现的个数即可
     * 但是首位为 1 时, 除了看后几位出现 1 的次数之外, 本身 首位的 1 也需要进行记录, 这个次数为 1 为首位, 可以组成数字的个数
     * 这里需要注意一点 为 0 时, 后面组成的数字不要看做是 8 了, 其实可以组成的数字是 0->9 但是 最大的首位能够组成的数字是受后面位数约束的
     *
     * 以 12345 为例进行分析： 这里为了说明方便 count(n) 代表 不大于n 出现的 1 的次数
     *      1、最高位为 0 和 1, 0 后面的数字范围为 0->9999, 1 后面的数字范围为 0->2345, 此时 1 为首位后面的数字个数为 2346
     *          则1的个数可以计算为：count(9999) + count(2345) + 2346
     *      2、此时递归计算 9999
     *          最高位为 0->9 除了 1 为末尾位之外, 其他首位后面的的数字范围为 0->999, 1 后面的数字范围为 0->999, 此时 1 为首位后面的数字个数为 1000
     *          最高位 9 后面的数字范围为 0->999
     *          则1的个数可以计算为 count(9999) * 9 + count(999) + 1000
     *      3、继续递归计算即可
     *
     * 这里需要注意的点在于：k 为 1 时, 1后面的数字范围取决于 后几位数字, 否则均为 0->9...9(取决于位数)
     *
     * @param n
     * @return
     */
    public int countDigitOne(int n) {
        // 数字为 1 位, 大于等于0则返回1
        if (n < 10) {
            return n >= 1 ? 1 : 0;
        }

        // 计算数字的长度, 方便后面进行计算
        int len = count(n);

        // num 用于获取 n 的最高位
        int num = (int) Math.pow(10, len - 1);
        int k = n / num;
        if (k > 1) {

            // 首位大于 1 则返回计算 9...9 (num - 1) 中 1的个数, 1为首位的数字个数为 num, 再计算最高位剩余的个数
            return countDigitOne(num - 1) * k + num + countDigitOne(n % num);
        } else {

            // 首位等于1, 1 的个数为 剩余个数 + 1
            return countDigitOne(num - 1) + n % num + 1 + countDigitOne(n % num);
        }
    }

    private int count(int n) {
        int len = 0;
        int t = n;
        while (t > 0) {
            len++;
            t /= 10;
        }

        return len;
    }
}
