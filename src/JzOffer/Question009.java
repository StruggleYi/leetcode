package JzOffer;

import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 23:30 2021/4/29
 * description 用两个栈实现队列
 * node:
 * path: https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
 * level: easy
 **/
public class Question009 {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    public void CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        if (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
        stack1.add(value);
    }

    public int deleteHead() {
        if (!stack2.isEmpty()){
            return stack2.pop();
        }

        if (stack1.isEmpty()){
            return -1;
        }

        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        int k = stack2.pop();
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }

        return k;
    }

}
