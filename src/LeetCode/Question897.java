package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 20:28 2021/4/25
 * description 递增顺序搜索树  按中序遍历 将其重新排列为一棵递增顺序搜索树
 * node: 中序遍历所有节点, 重新排列即可
 * path: https://leetcode.com/problems/increasing-order-search-tree/
 * https://leetcode-cn.com/problems/increasing-order-search-tree/
 * level: easy
 **/
public class Question897 {
    public TreeNode increasingBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }

        List<TreeNode> list = new ArrayList<>();
        midSearch(root, list);

        TreeNode head = list.get(0);
        TreeNode p = head;
        for (int i = 1; i < list.size(); i++) {
            p.right = list.get(i);
            p.left = null;
            p = p.right;
        }
        p.left = null;
        p.right = null;

        return head;
    }

    public void midSearch(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        midSearch(root.left, list);
        list.add(root);
        midSearch(root.right, list);
    }
}
