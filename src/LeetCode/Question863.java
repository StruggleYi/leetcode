package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 21:29 2021/7/28
 * description 二叉树中所有距离为 K 的结点
 * node: 记录父节点、已遍历的节点
 * path: https://leetcode-cn.com/problems/all-nodes-distance-k-in-binary-tree/
 * level: medium
 **/
public class Question863 {

    Set<Integer> set = new HashSet<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();
    List<Integer> res = new ArrayList<>();

    /**
     * 子节点很容易计算, 往下遍历即可, 关键在于要记录已遍历的节点、记录父节点
     *
     * @param root
     * @param target
     * @param k
     * @return
     */
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // 记录每个父节点
        search(root);
        map.put(root, null);

        // 先找到当前节点距离为 K 的子节点
        help(target, k);
        TreeNode parentNode = map.get(target);

        // 一直往上遍历父节点, 直到根节点位置
        while (parentNode != null) {

            // 如果到该父节点距离正好为 K, 则往上遍历到头
            if (k - 1 == 0) {
                res.add(parentNode.val);
                break;
            }
            set.add(parentNode.val);

            // 遍历另一个子节点, 由于已记录遍历过的节点, 这里不用判断, 直接计算即可
            help(parentNode.left, k - 2);
            help(parentNode.right, k - 2);
            k--;
            parentNode = map.get(parentNode);
        }

        return res;
    }

    /**
     * 遍历, 记录每个节点的父节点的位置
     *
     * @param root
     */
    private void search(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left != null) {
            map.put(root.left, root);
            search(root.left);
        }

        if (root.right != null) {
            map.put(root.right, root);
            search(root.right);
        }
    }

    /**
     * 记录当前节点往下距离为 K 的节点
     *
     * @param root
     * @param k
     */
    private void help(TreeNode root, int k) {
        if (k < 0 || root == null || set.contains(root.val)) {
            return;
        }

        set.add(root.val);
        if (k == 0) {
            res.add(root.val);
            return;
        }

        help(root.left, k - 1);
        help(root.right, k - 1);
    }
}
