package JzOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 22:44 2021/6/30
 * description 序列化二叉树  请实现两个函数，分别用来序列化和反序列化二叉树。
 * node:
 * path: https://leetcode-cn.com/problems/xu-lie-hua-er-cha-shu-lcof/
 * level: hard
 **/
public class Question037 {


    int INF = -2000;
    TreeNode emptyNode = new TreeNode(INF);

    /**
     *  层次遍历, 空位置用特殊数值标记
     */
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        while (!d.isEmpty()) {
            TreeNode poll = d.pollFirst();
            sb.append(poll.val + "_");
            if (!poll.equals(emptyNode)) {
                d.addLast(poll.left != null ? poll.left : emptyNode);
                d.addLast(poll.right != null ? poll.right : emptyNode);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        if (data.equals("")) {
            return null;
        }

        String[] ss = data.split("_");
        int n = ss.length;
        TreeNode root = new TreeNode(Integer.parseInt(ss[0]));
        Deque<TreeNode> d = new ArrayDeque<>();
        d.addLast(root);
        for (int i = 1; i < n - 1; i += 2) {
            TreeNode poll = d.pollFirst();
            int a = Integer.parseInt(ss[i]), b = Integer.parseInt(ss[i + 1]);
            if (a != INF) {
                poll.left = new TreeNode(a);
                d.addLast(poll.left);
            }
            if (b != INF) {
                poll.right = new TreeNode(b);
                d.addLast(poll.right);
            }
        }
        return root;
    }

    int i = 0;

    /**
     * 序列化二叉树, 将其转为前序和中序遍历的集合
     * 由于二叉树可能包含同样的数值, 需要对值做特殊标记
     *
     * @param root
     * @return
     */
    public String serialize2(TreeNode root) {
        // 序列化为前序和中序遍历结果的字符串
        StringBuilder pre = new StringBuilder();
        StringBuilder mid = new StringBuilder();
        search(root, pre, mid);

        return pre.toString() + mid.toString();
    }

    /**
     * 前序和中序的结果进行拆分, 递归可以复原二叉树
     *
     * @param data
     * @return
     */
    public TreeNode deserialize2(String data) {
        // 将其拆分为二, 前序和中序遍历结果可确定唯一的二叉树
        String[] strings = data.split(",");
        int len = strings.length;
        List<String> pre = new ArrayList<>();
        List<String> mid = new ArrayList<>();

        for (int i = 0; i < len / 2; i++) {
            pre.add(strings[i]);
            mid.add(strings[i + len / 2]);
        }

        return rebuildTree(pre, mid, 0, len / 2 - 1, 0, len / 2 - 1);
    }

    private void search(TreeNode root, StringBuilder pre, StringBuilder mid) {
        if (root == null) {
            return;
        }

        String s = root.val + "&" + i;
        pre.append(s).append(",");
        i++;
        search(root.left, pre, mid);
        mid.append(s).append(",");
        i++;
        search(root.right, pre, mid);
    }

    private TreeNode rebuildTree(List<String> pre, List<String> mid, int i, int j, int m, int n) {
        if (i > j) {
            return null;
        }

        int val = Integer.valueOf(pre.get(i).split("&")[0]);
        TreeNode root = new TreeNode(val);
        if (i == j) {
            return root;
        }

        int k = mid.indexOf(pre.get(i));
        int left = k - m;

        root.left = rebuildTree(pre, mid, i + 1, i + left, m, k - 1);
        root.right = rebuildTree(pre, mid, i + left + 1, j, k + 1, n);

        return root;
    }
}
