/**
 * @author Struggle
 * @date Created in 9:17 2019/10/31
 * description  Binary Tree Maximum Path Sum  求二叉树最大路径和(此路径可以为左节点到父节点到右节点), 任意节点出发
 *
 * path: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 * level:  hard
 *
 * 思路： 采用递归的思想, 从叶节点出发, 求得当前最长路径的和, 由于路径是连续的, 此时要注意一点, 返回值只能返回包含叶节点以及其中一个最大子节点的值
 *       因为如果把两个子节点的值都返回以后会导致路径不符合要求
 **/
public class Question124 {

    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        find(root);
        return max;
    }

    public int find(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            max = Math.max(root.val, max);
            return root.val;
        }

        int left = find(root.left);
        int right = find(root.right);

        //此时不断更新最大值, 可能包含子节点或者不包含子节点
        max = Math.max(max, root.val);
        max = Math.max(max, left + root.val);
        max = Math.max(max, right + root.val);
        max = Math.max(max, left + right + root.val);

        //返回当前指向节点的路径的最大值, 不能同时包含左子树和右子树, 否则会导致不能构成一条路径, 实际情况会分叉
        if (left >= right && left > 0){
            return root.val + left;
        }else if (left < right && right > 0){
            return root.val + right;
        }else {
            return root.val;
        }
    }


    public static void main(String[] args) {
        Question124 q = new Question124();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        a.left = b;
        a.right = c;
        System.out.println(q.maxPathSum(a));
    }
}
