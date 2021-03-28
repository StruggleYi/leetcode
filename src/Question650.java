import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 16:55 2021/3/28
 * description 2 Keys Keyboard 键盘只有两个操作, 复制当前所有字符串和粘贴前一次所复制的内容, 给定一个数字n, 返回最小操作次数能获取到长度为n的字符串
 * node: 这个题目的本质在于将n进行分解成最小数字相乘的形式, 找出最大的质数, 以此为最小单位进行复制
 * path: https://leetcode.com/problems/2-keys-keyboard/
 * level: medium
 **/
public class Question650 {
    public int minSteps(int n) {
        int sum = 0;

        List<Integer> res = new ArrayList<>();

        int k = 2;
        // 计算所有的整除的数字
        while (k * k <= n && k < n) {
            if (n % k == 0) {
                res.add(k);
                n /= k;
            } else {
                k++;
            }
        }

        // 如果存在大于1的质数不能被整除, 则需要经过n次操作才能获取到该值
        if (n > 1) {
            sum += n;
        }

        // 对于每个整除的数字, 代表可以通过复制粘贴的形式快速获取
        // 比如3, 代表获取三倍后的结果, 即只需要复制一次和粘贴两次即可, 需要的操作次数为整除数
        for (Integer m : res) {
            sum += m;
        }

        return sum;
    }

    public static void main(String[] args) {
        Question650 q = new Question650();
        System.out.println(q.minSteps(999));
    }
}
