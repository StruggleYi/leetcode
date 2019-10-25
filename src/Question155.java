import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 8:44 2019/10/25
 * description Min Stack
 **/
public class Question155 {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    public void MinStack() {
    }

    /**如果x比当前最小值小,则将当前最小值入栈
     * eg.  -1  -2  -3
     * push(-1)
     *     stack -1
     * push(-2)
     *           -2  <- 真实值
     *           -1  <- 上一个最小值
     *     stack -1  <- 真实值
     * push(-3)
     *           -3  <- 真实值
     *           -2  <- 上一个最小值
     *           -2  <- 真实值
     *           -1  <- 上一个最小值
     *     stack -1  <- 真实值
     */
    public void push(int x) {
        if (stack.isEmpty()) {
            min = x;
        } else if (min >= x) {
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    /**
     * 弹出时如果最小值为当前栈顶的值,则将上一个最小值弹出赋给min
     */
    public void pop() {
        int num = stack.pop();
        if (num == min && !stack.isEmpty()) {
            min = stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        Question155 minStack = new Question155();
        minStack.MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
