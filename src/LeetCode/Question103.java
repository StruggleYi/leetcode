package LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 9:02 2019/11/29
 * description Binary Tree Zigzag Level Order Traversal 层次遍历, 依次保存每一层中的数据, 按照从左到右、从右到左的顺序循环
 * path: https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/description/
 * level: medium
 **/
public class Question103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        TreeNode flag = root;
        int k = 1;
        List<Integer> list = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode p = queue.pop();
            list.add(p.val);
            if (p.left != null){
                queue.add(p.left);
            }
            if (p.right != null){
                queue.add(p.right);
            }
            if (flag == p){
                if (k == -1){
                    Collections.reverse(list);
                }
                k = -k;
                lists.add(new ArrayList<>(list));
                list = new ArrayList<>();
                if (!queue.isEmpty()){
                    flag = queue.getLast();
                }
            }
        }
        return lists;
    }

    public static void main(String[] args) {
    //同102  测试代码略, 代码已通过在线测试
    }
}
