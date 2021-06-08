package JzOffer;

import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 22:51 2021/6/8
 * description 栈的压入、弹出序列  输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * node:
 * path: https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
 * level: medium
 **/
public class Question031 {

    /**
     * leetCode 借鉴思路 使用数组模拟栈即可
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed.length == 0 && popped.length == 0) {
            return true;
        } else if (pushed.length == 0 || popped.length == 0) {
            return false;
        }
        int top = -1, popIndex = 0;
        for (int num : pushed) {
            // pushed相当于就是一个栈, 使用数字记录当前位移的位置
            pushed[++top] = num;
            while (top >= 0 && pushed[top] == popped[popIndex]) {
                --top;
                ++popIndex;
            }
        }
        return top == -1;
    }

    /**
     * 使用栈的做法
     *
     * @param pushed
     * @param popped
     * @return
     */
    public boolean validateStackSequences2(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();

        int i = 0, j = 0;
        // i等于pushed.length的情况在于, 所有的数字都push, 但是可以按序pop满足要求
        while (i <= pushed.length) {

            // 栈空并且还有数字可以Push, 直接压栈
            if (stack.isEmpty() && i < pushed.length) {
                stack.push(pushed[i++]);
            } else if (!stack.isEmpty() && stack.peek() == popped[j]) {
                // 栈不为空并且栈顶值与弹出值相等, 出栈
                j++;
                stack.pop();
            } else if (i < pushed.length) {
                // 栈不为空, 并且栈顶数字与要弹出的不同, 继续push
                stack.push(pushed[i++]);
            } else {
                // 没有可以push的数字了, 退出循环
                break;
            }
        }

        // 所有数字出栈, 并且pop数组的值全部匹配完成, 代表满足栈的出入规则
        return stack.isEmpty() && j == popped.length;
    }

    public static void main(String[] args) {
        Question031 q = new Question031();
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 3, 5, 1, 2};
        System.out.println(q.validateStackSequences(pushed, popped));
    }
}
