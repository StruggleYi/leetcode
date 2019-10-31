/**
 * @author Struggle
 * @date Created in 16:49 2019/10/31
 * description Power of Four 判断数字k是否是4的指数倍, 不使用递归或者循环
 **/
public class Question342 {

    /**
     * 循环解法
     */
    public boolean isPowerOfFour(int num) {
        while (num > 1 && num % 4 == 0) {
            num /= 4;
        }
        return num == 1;
    }

    /**
     * 非循环解法1
     * 换底公式 log a (b) = log c (b)/ log c (a)
     * 查看计算结果是否为整数
     */
    public boolean isPowerOfFour2(int num) {
        return (Math.log(num) / Math.log(4)) % 1 == 0;
    }

    /**
     * 非循环解法2
     * 首先num > 0
     * 由于4的指数的数的二进制中的1的个数为1, 于是该数字k 与 k-1 相与, 结果应该为0
     * 而且1出现的位置在0x55555555之中
     * 查看计算结果是否为整数
     */
    public boolean isPowerOfFour3(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        Question342 q = new Question342();
        System.out.println(q.isPowerOfFour2(20));
    }
}
