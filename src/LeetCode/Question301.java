package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 10:50 2019/11/14
 * description Remove Invalid Parentheses 删除无效括号的最小数目, 以使输入字符串有效. 返回所有可能的结果. 字符串可能包含非括号字符
 * path: https://leetcode.com/problems/remove-invalid-parentheses/description/
 * level: hard
 **/
public class Question301 {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        remove(s, ans, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    /**
     * 借鉴思路: 该思路的思想为：从头到尾先进行一次遍历, 如果左括号比右括号的少, 则说明要把右括号的数量减一, 这里使用递归, 依次把可以去掉的右括号进行遍历
     * 该思路很重要的一点是, 没有直接判断该字符串是否符合要求, 先进行正序遍历, 可以把多余的右括号去掉, 这里没有考虑左括号的情况
     * 比较创新的思路为: 将该字符串进行翻转, 在进行一次同样的操作, 可以把多余的左括号给去掉, 该思路很值得借鉴
     * 这里的i, j 用来记录递归时当前i, j所指向的位置, 避免重复进行计算
     */
    public void remove(String s, List<String> ans, int last_i, int last_j,  char[] par) {
        for (int stack = 0, i = last_i; i < s.length(); ++i) {
            if (s.charAt(i) == par[0]) {
                stack++;
            }
            if (s.charAt(i) == par[1]) {
                stack--;
            }
            if (stack >= 0) {
                continue;
            }
            // 遍历减去可以减去的不同位置的括号
            for (int j = last_j; j <= i; ++j) {
                if (s.charAt(j) == par[1] && (j == last_j || s.charAt(j - 1) != par[1])) {
                    remove(s.substring(0, j) + s.substring(j + 1), ans, i, j, par);
                }
            }
            return;
        }

        String reversed = new StringBuilder(s).reverse().toString();
        //如果 为左括号, 则说明只进行了一次遍历, 需要反向再进行一次判断, 这里的做法是将字符串翻转, 在把左右括号的位置进行互换, 则可以达到反向判断的效果
        if (par[0] == '(') {
            remove(reversed, ans, 0, 0, new char[]{')', '('});
        } else
        {
            ans.add(reversed);
        }
    }


    public static void main(String[] args) {
        Question301 q = new Question301();
        String s = "()())()";
        System.out.println(q.removeInvalidParentheses(s).toString());
    }
}
