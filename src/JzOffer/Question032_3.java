package JzOffer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 23:03 2021/6/11
 * description 从上到下打印二叉树 III 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印 第三行再按照从左到右的顺序打印，其他行以此类推
 * node: 偶数层翻转一下结果即可
 * path: https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-iii-lcof/
 * level: medium
 **/
public class Question032_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, root, 0);

        int i = 0;
        for (List<Integer> list : res) {
            if (i % 2 == 1) {
                Collections.reverse(list);
            }
            i++;
        }
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
}
