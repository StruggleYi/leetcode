import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 20:41 2021/4/25
 * description 笨阶乘 在整数的递减序列中，我们以一个固定顺序的操作符序列来依次替换原有的乘法操作符：乘法(*)，除法(/)，加法(+)和减法(-)
 * node: 先算乘除, 再算加减即可, 计算器的变形
 *       注：参考题解, 可以计算规律
 * path: https://leetcode-cn.com/problems/clumsy-factorial/
 * level: medium
 **/
public class Question1006 {

    /**
     * 参考题解的递推公式, 有兴趣可以看一下题解
     * 链接如下：https://leetcode-cn.com/problems/clumsy-factorial/solution/gong-shui-san-xie-tong-yong-biao-da-shi-nngfp/
     *
     * @param N
     * @return
     */
    public int clumsy(int N) {
        if (N == 1 || N == 2) {
            return N;
        }
        if (N == 3) {
            return 6;
        }
        if (N == 4) {
            return 7;
        }
        //上面是特殊情况，下面是根据公式推算的
        if (N % 4 == 0) {
            return N + 1;
        }
        if (N % 4 == 1 || N % 4 == 2) {
            return N + 2;
        }
        return N - 1;
    }


    public int clumsy2(int N) {
        Stack<Integer> stack = new Stack<>();

        int flag = 1;
        stack.add(N);
        while (--N >= 1) {
            if (flag % 4 == 1) {
                stack.push(stack.pop() * N);
            } else if (flag % 4 == 2) {
                stack.push(stack.pop() / N);
            } else if (flag % 4 == 0) {
                stack.push(-N);
            } else {
                stack.push(N);
            }
            flag++;
        }

        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        Question1006 q = new Question1006();
        System.out.println(q.clumsy(10));
    }
}
