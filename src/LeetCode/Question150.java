package LeetCode;

import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 20:36 2021/1/14
 * description Evaluate Reverse Polish Notation 逆波兰表达式
 * node: 使用栈存储数字即可
 * path: https://leetcode.com/problems/evaluate-reverse-polish-notation/
 * level: medium
 **/
public class Question150 {
    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        for (String s : tokens) {
            int b;
            int a;
            switch (s) {
                case "+":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a + b));
                    break;
                case "-":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a - b));
                    break;
                case "*":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a * b));
                    break;
                case "/":
                    b = Integer.valueOf(stack.pop());
                    a = Integer.valueOf(stack.pop());
                    stack.push(String.valueOf(a / b));
                    break;
                default:
                    stack.push(s);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        Question150 q = new Question150();
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(q.evalRPN(tokens));
    }
}
