package LeetCode;

/**
 * @author Struggle
 * @date Created in 2025/4/4 16:24
 * description 最深叶节点的最近公共祖先
 * node:
 * path:
 * level: medium
 **/
public class Question1123 {

    int maxDepth = 0;
    TreeNode result;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return result;
    }

    private int dfs(TreeNode node, int depth) {

        if (node == null){
            maxDepth = Math.max(depth, maxDepth);
            return depth;
        }

        int leftDepth = dfs(node.left, depth + 1);
        int rightDepth = dfs(node.right, depth + 1);

        if (leftDepth == maxDepth && rightDepth == maxDepth)
            result = node;

        return Math.max(leftDepth, rightDepth);
    }
}

