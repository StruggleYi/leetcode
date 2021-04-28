package JzOffer;


/**
 * @author Struggle
 * @date Created in 20:18 2021/4/28
 * description 重建二叉树 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树
 * node:
 * path: https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/
 * level: medium
 **/
public class Question007 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }

        return reBuild(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }


    private TreeNode reBuild(int[] preorder, int[] inorder, int i, int j, int m, int n) {
        if (i > j) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[i]);
        int z = 0;
        for (; z + m <= n; z++) {
            if (inorder[z + m] == preorder[i]) {
                break;
            }
        }

        root.left = reBuild(preorder, inorder, i + 1, i + z, m, m + z - 1);
        root.right = reBuild(preorder, inorder, i + z + 1, j, m + z + 1, n);
        return root;
    }


    public static void main(String[] args) {
        Question007 q = new Question007();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        q.buildTree(preorder, inorder);
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}