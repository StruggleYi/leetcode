package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:04 2021/7/27
 * description 二叉树中第二小的节点   节点的子节点个数为 0 或者2
 * node:
 * path: https://leetcode-cn.com/problems/second-minimum-node-in-a-binary-tree/
 * level: easy
 **/
public class Question671 {
    public int findSecondMinimumValue(TreeNode root) {
        return find(root);
    }

    private int find(TreeNode root) {
        if (root == null || root.left == null) {
            return -1;
        }

        int k = Math.max(root.left.val, root.right.val);
        if (k == root.val) {
            int left = find(root.left);
            int right = find(root.right);

            if (left == -1) {
                return right;
            } else if (right == -1) {
                return left;
            } else {
                return Math.min(left, right);
            }
        }

        if (Math.min(root.left.val, root.right.val) > root.val) {
            return k;
        }

        int min = 0;
        if (root.left.val == root.val) {
            min = find(root.left);
        }
        if (root.right.val == root.val) {
            min = find(root.right);
        }
        if (min == -1){
            return k;
        }

        return Math.min(min, k);
    }
}
