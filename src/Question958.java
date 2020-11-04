import java.util.ArrayDeque;

/**
 * @author Struggle
 * @date Created in 2020/11/4 10:25
 * description Check Completeness of a Binary Tree 判断一颗二叉树是否是完全二叉树
 * node: 层次遍历，确定第一个没有或者只有左子树的节点，后面的节点均不能包含子树
 * path: https://leetcode.com/problems/check-completeness-of-a-binary-tree/
 * level: medium
 **/
public class Question958 {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean flag = true;
        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.pop();
            if (p.left == null && p.right != null || !flag && p.left != null) {
                return false;
            }
            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.left != null && p.right != null) {
                queue.add(p.right);
            }
            if (p.left == null || p.right == null) {
                flag = false;
            }
        }
        return true;
    }
}
