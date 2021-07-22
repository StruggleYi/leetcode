package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:08 2021/4/13
 * description Minimum Distance Between BST Nodes 求平衡二叉树任意两节点的差的最小值
 * node: 中序遍历, 求出该节点与前一个节点的差的最小值即可
 * path: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 * level: easy
 **/
public class Question783 {

    /**
     * pre 用来记录遍历的上一个节点
     */
    TreeNode pre = null;
    int min = 100001;

    public int minDiffInBST(TreeNode root) {
        midSearch(root);
        return min;
    }

    public void midSearch(TreeNode root) {
        if (root == null) {
            return;
        }

        midSearch(root.left);
        // 如果pre 为空, 则代表是最左子节点
        if (pre == null) {
            pre = root;
        } else {
            min = Math.min(min, root.val - pre.val);
            pre = root;
        }

        midSearch(root.right);
    }

}
