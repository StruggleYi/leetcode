package JzOffer;

import java.util.ArrayDeque;
import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 21:31 2021/6/3
 * description 树的子结构  输入两棵二叉树A和B，判断B是不是A的子结构
 * node: 注意B可能只是A树中间都一部分
 * path: https://leetcode-cn.com/problems/shu-de-zi-jie-gou-lcof/
 * level: medium
 **/
public class Question026 {

    /**
     * 递归解法
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        return judge(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    private boolean judge(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null) {
            return false;
        }
        return (A.val == B.val) && judge(A.left, B.left) && judge(A.right, B.right);
    }

    /**
     * 非递归解法
     *
     * @param A
     * @param B
     * @return
     */
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if (B == null) {
            return false;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(A);

        while (!queue.isEmpty()) {
            TreeNode p = queue.pop();
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }

            if (p.val == B.val && judge2(p, B)) {
                return true;
            }
        }

        return false;
    }

    private boolean judge2(TreeNode A, TreeNode B) {
        Stack<TreeNode> stackA = new Stack<>();
        Stack<TreeNode> stackB = new Stack<>();
        stackA.push(A);
        stackB.push(B);

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            TreeNode p = stackA.pop();
            TreeNode q = stackB.pop();

            if (p.val != q.val) {
                return false;
            }

            if (q.left != null) {
                if (p.left == null) {
                    return false;
                }
                stackA.add(p.left);
                stackB.add(q.left);
            }

            if (q.right != null) {
                if (p.right == null) {
                    return false;
                }
                stackA.add(p.right);
                stackB.add(q.right);
            }
        }

        return stackB.isEmpty();
    }
}
