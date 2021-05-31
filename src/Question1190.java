/**
 * @author Struggle
 * @date Created in 22:35 2021/5/26
 * description 反转每对括号间的子串
 * node: 使用队列的思想, 没遇到 ) 之前往队尾添加, 遇到) 则往前寻找 ( 然后把中间数字进行翻转 在放置到队列中
 * path: https://leetcode-cn.com/problems/reverse-substrings-between-each-pair-of-parentheses/
 * level: medium
 **/
public class Question1190 {
    /**
     * deque 模拟队列
     */
    char[] deque = new char[2009];
    int head = 0, tail = -1;
    /**
     * path 用来记录 () 之间的字符
     */
    char[] path = new char[2009];

    public String reverseParentheses(String s) {
        int n = s.length();
        char[] cs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            char c = cs[i];

            // 遇到右括号就去寻找左括号
            if (c == ')') {
                // idx 记录中间数字的个数
                int idx = 0;
                while (tail >= head) {

                    // 遇到左括号, 把path中的字符重新放回队列
                    if (deque[tail] == '(') {
                        tail--;
                        for (int j = 0; j < idx; j++) {
                            deque[++tail] = path[j];
                        }
                        break;
                    } else {
                        // 没遇到左括号, 倒序记录()之间的字符串
                        path[idx++] = deque[tail--];
                    }
                }
            } else {
                // 没遇到右括号, 直接往队尾添加即可
                deque[++tail] = c;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (tail >= head) {
            sb.append(deque[head++]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question1190 q = new Question1190();
        System.out.println(q.reverseParentheses("ta()usw((((a))))"));
    }
}
