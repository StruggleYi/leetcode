package JzOffer;

import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 23:36 2021/6/7
 * description 包含min函数的栈 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 * node: 每次push的时候同时记录最小值和本身值
 * path: https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof/
 * level: easy
 **/
public class Question030 {

    Stack<Integer> stack;

    public void MinStack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        int min;
        if (stack.isEmpty()) {
            min = x;
        } else {
            min = Math.min(stack.peek(), x);
        }

        stack.push(x);
        stack.push(min);
    }

    public void pop() {
        stack.pop();
        stack.pop();
    }

    public int top() {
        int min = stack.pop();
        int top = stack.peek();
        stack.add(min);
        return top;
    }

    public int min() {
        return stack.peek();
    }
}
