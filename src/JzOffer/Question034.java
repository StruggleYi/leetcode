package JzOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 21:09 2021/6/13
 * description 二叉树中和为某一值的路径
 * node:
 * path: https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
 * level: medium
 **/
public class Question034 {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }

        search(root, target, new ArrayList<>(), 0);

        return res;
    }

    public void search(TreeNode root, int target, List<Integer> list, int now) {
        list.add(root.val);
        if (root.left == null && root.right == null && target == now + root.val) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (root.left != null) {
            search(root.left, target, new ArrayList<>(list), now + root.val);
        }
        if (root.right != null) {
            search(root.right, target, new ArrayList<>(list), now + root.val);
        }
    }

}
