package LeetCode;

import java.util.ArrayDeque;

/**
 * @author Struggle
 * @date Created in 22:56 2021/5/17
 * description  二叉树的堂兄弟节点
 * node: 记录两个节点的高度以及父节点
 * path: https://leetcode-cn.com/problems/cousins-in-binary-tree/
 * level: easy
 **/
public class Question993 {
    public boolean isCousins(TreeNode root, int x, int y) {

        int a = 0;
        int b = 0;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        int k = 1;
        TreeNode end = root;
        TreeNode q = root;

        TreeNode xFather = null;
        TreeNode yFather = null;

        if (root.val == x) {
            a = k;
        }

        if (root.val == y) {
            b = k;
        }

        while (!queue.isEmpty()) {
            TreeNode p = queue.pop();

            if (p.left != null) {
                queue.add(p.left);
                q = p.left;

                if (a == 0 || b == 0){
                    if (p.left.val == x){
                        xFather = p;
                        a = k + 1;
                    }

                    if (p.left.val == y){
                        yFather = p;
                        b = k + 1;
                    }
                }
            }

            if (p.right != null) {
                queue.add(p.right);
                q = p.right;

                if (a == 0 || b == 0){
                    if (p.right.val == x){
                        xFather = p;
                        a = k + 1;
                    }

                    if (p.right.val == y){
                        yFather = p;
                        b = k + 1;
                    }
                }
            }

            if (p == end) {
                end = q;
                k++;
            }
        }

        return a == b && xFather != yFather;
    }

}
