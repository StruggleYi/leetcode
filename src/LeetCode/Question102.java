package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 10:23 2019/11/28
 * description Binary Tree Level Order Traversal 二叉树层次遍历, 把每一层的数字
 * path: https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * level: medium
 **/
public class Question102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null){
            return lists;
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        List<Integer> list = new ArrayList<>();
        TreeNode flag = root;
        while (!queue.isEmpty()) {
            TreeNode p = queue.pop();
            list.add(p.val);
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
            if (p == flag) {
                lists.add(new ArrayList<>(list));
                list = new ArrayList<>();
                if (!queue.isEmpty()) {
                    flag = queue.getLast();
                }
            }
        }

        return lists;
    }

    public static void main(String[] args) {
        Question102 q = new Question102();
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(5);
        a.left = b;
        a.right = c;
        List<List<Integer>> lists = q.levelOrder(a);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
