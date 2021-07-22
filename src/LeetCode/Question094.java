package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 16:30 2019/11/26
 * description Binary Tree Inorder Traversal 二叉树前序遍历 非递归
 * path: https://leetcode.com/problems/binary-tree-inorder-traversal/description/
 * level: medium
 **/
public class Question094 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null){
            return list;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        while (p != null || !stack.empty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            list.add(p.val);

            p = p.right;
        }
        return list;
    }

    public static void main(String[] args) {
        Question094 q = new Question094();
        TreeNode r = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(5);
        r.left = a;
        a.right = b;
        List<Integer> list = q.inorderTraversal(r);
        System.out.println(list.toString());
    }
}
