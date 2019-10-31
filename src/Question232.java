import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 10:18 2019/10/31
 * description Implement Queue using Stacks  使用栈实现队列
 **/
public class Question232 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> temp = new Stack<>();
    Integer peek = null;
    /** Initialize your data structure here. */
    public void MyQueue() {
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (stack.isEmpty()){
            peek = x;
        }
        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while (!stack.isEmpty()){
            temp.push(stack.pop());
        }
        int k = temp.pop();
        if (temp.isEmpty()){
            peek = null;
        }else {
            peek = temp.peek();
        }
        while (!temp.isEmpty()){
            stack.push(temp.pop());
        }
        return k;
    }

    /** Get the front element. */
    public int peek() {
        return peek;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        //未写测试用例, 结果正确
    }
}
