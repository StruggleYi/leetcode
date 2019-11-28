/**
 * @author Struggle
 * @date Created in 9:04 2019/11/28
 * description Validate Binary Search Tree 判断给定的二叉树是否满足二叉搜索树的条件
 * path: https://leetcode.com/problems/validate-binary-search-tree/description/
 * level: medium
 **/
public class Question098 {
    public boolean isValidBST(TreeNode root) {
        return fun(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean fun(TreeNode root, long max, long min) {
        if (root == null) {
            return true;
        }

        if (root.val >= max || root.val <= min) {
            return false;
        }

        //左子树上的节点 均不能大于父节点, 所以把父节点的值定为max
        //右子树上的节点 均不能小于父节点, 所以把父节点的值定为min
        return fun(root.left, root.val, min) && fun(root.right, max, root.val);
    }

    public static void main(String[] args) {
        Question098 q = new Question098();
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(1);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println(q.isValidBST(a));
    }
}
