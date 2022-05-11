package LeetCode;

import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 22:56 2022/5/11
 * description 序列化和反序列化二叉搜索树
 * node: 先序遍历存储压缩结果, 解压时依次恢复即可
 * path: https://leetcode.cn/problems/serialize-and-deserialize-bst/
 * level: medium
 **/
public class Question449 {

    StringBuilder sb = new StringBuilder();

    public String serialize(TreeNode root) {
        // 先序遍历
        preOrder(root);
        return sb.toString().trim();
    }

    private void preOrder(TreeNode p) {
        if (p == null) {
            return;
        }
        // 空格区分
        sb.append(p.val).append(" ");
        preOrder(p.left);
        preOrder(p.right);
    }


    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }

        // 拆分数字
        String[] strings = data.split(" ");

        // 构建根节点
        TreeNode root = new TreeNode(Integer.valueOf(strings[0]));
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        for (int i = 1; i < strings.length; ) {
            TreeNode p = stack.peek();
            int val = Integer.valueOf(strings[i]);
            TreeNode q = new TreeNode(val);

            // 比当前节点小, 则在左子树
            if (p.val > val) {
                p.left = q;
                stack.push(q);
                i++;
            } else {
                // 当前节点直接弹出, 无回溯用到该点的情况
                stack.pop();

                // 判断是否到达根节点, 或者该节点应该出现在更高层级的节点的右子树
                // 栈为空, 到达根节点, 或者该节点的父节点也大于当前值
                // 说明该点在当前节点的右子树
                // 否则舍弃， 向上寻找位置，直到根节点
                if (stack.isEmpty() || stack.peek().val > val) {
                    p.right = q;
                    stack.push(q);
                    i++;
                }
            }
        }

        return root;
    }
}
