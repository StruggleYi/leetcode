package JzOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 22:45 2021/6/10
 * description 从上到下打印二叉树 II 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行
 * node:
 * path: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof/
 * level: easy
 **/
public class Question032_2 {

    /**
     * 使用递归, 记录每层的高度, 将其放入不同的list中
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, 0);
        return res;
    }

    private void dfs(List<List<Integer>> temp, TreeNode root, int height) {
        if (root == null) {
            return;
        }
        // 一层一个 List
        if (height >= temp.size()) {
            temp.add(new ArrayList<>());
        }
        temp.get(height).add(root.val);
        dfs(temp, root.left, height + 1);
        dfs(temp, root.right, height + 1);
    }

    /**
     * 非递归, 使用队列, 记录每层的尾节点
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder2(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        List<List<Integer>> res = new ArrayList<>();


        while (!queue.isEmpty()) {

            List<Integer> list = new ArrayList<>();
            // 当前队列的大小, 为该层中的节点的个数, 将该个数记录下来, 取出这么多个数的节点即可
            for (int i = queue.size(); i > 0; i--) {
                TreeNode p = queue.pop();
                list.add(p.val);

                if (p.left != null) {
                    queue.add(p.left);
                }

                if (p.right != null) {
                    queue.add(p.right);
                }
            }

            res.add(list);
        }

        return res;
    }

}
