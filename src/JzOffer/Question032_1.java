package JzOffer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 23:52 2021/6/9
 * description 从上到下打印二叉树
 * node: 层次遍历
 * path: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof/
 * level: medium
 **/
public class Question032_1 {

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }

        List<Integer> list = new ArrayList<>();

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode p = queue.pop();
            list.add(p.val);

            if (p.left != null) {
                queue.add(p.left);
            }
            if (p.right != null) {
                queue.add(p.right);
            }
        }

        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}
