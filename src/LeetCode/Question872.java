package LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 20:59 2021/5/10
 * description 叶子相似的树 如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的
 * node: 可以使用递归和非递归的方式解决
 * path: https://leetcode-cn.com/problems/leaf-similar-trees/
 * level: easy
 **/
public class Question872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = findLeafNode(root1);
        List<Integer> list2 = findLeafNode(root2);

        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (!list1.get(i).equals(list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    public List<Integer> findLeafNode(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
            if (p.left == null && p.right == null) {
                list.add(p.val);
                continue;
            }

            if (p.left != null) {
                stack.push(p.left);
            }
            if (p.right != null) {
                stack.push(p.right);
            }
        }

        return list;
    }
}
