package JzOffer;

/**
 * @author Struggle
 * @date Created in 23:55 2021/6/4
 * description 二叉树的镜像
 * node: 递归交换每个树的左右节点位置
 * path: https://leetcode-cn.com/problems/er-cha-shu-de-jing-xiang-lcof/
 * level: easy
 **/
public class Question027 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        root.right = left;
        root.left = right;

        mirrorTree(left);
        mirrorTree(right);

        return root;
    }
}
