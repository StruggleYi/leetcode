package LeetCode;

/**
 * @author Struggle
 * @date Created in 10:10 2019/10/31
 * description   Invert Binary Tree  二叉树翻转
 *
 * path: https://leetcode.com/problems/invert-binary-tree/description/
 * level: easy
 **/
public class Question226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)){
            return root;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.right = left;
        root.left = right;

        return root;
    }

    public static void main(String[] args) {
        Question226 q = new Question226();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(4);
        root.right = a;
        a.left = b;
        root = q.invertTree(root);
        System.out.println(root.left.val);
    }
}
