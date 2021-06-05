package JzOffer;

/**
 * @author Struggle
 * @date Created in 16:49 2021/6/5
 * description 对称的二叉树
 * node:
 * path: https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof/
 * level: easu
 **/
public class Question028 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }

        return equal(root.left, root.right);
    }

    private boolean equal(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.val == q.val && equal(p.left, q.right) && equal(p.right, q.left);
    }
}
