import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 20:55 2021/1/15
 * description Average of Levels in Binary Tree 求二叉树每层节点值的平均数
 * node: 层次遍历即可
 * path: https://leetcode.com/problems/average-of-levels-in-binary-tree/
 * level: easy
 **/
public class Question637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null){
            return res;
        }

        TreeNode tail = root;

        ArrayDeque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // 可能出现多个子节点的和超过int界限的值，所以这里取long来存和
        long sum = 0;
        int k = 0;

        while (!queue.isEmpty()){
            TreeNode p = queue.peek();
            sum += p.val;
            k++;
            if (p.left != null){
                queue.add(p.left);
            }
            if (p.right != null){
                queue.add(p.right);
            }

            // 记录每一层的尾结点
            if (p == tail){
                res.add(sum * 1.0 / k);
                sum = 0;
                k = 0;
                tail = queue.getLast();
            }
            // 最后才取出值是因为如果最后一个节点在最开始被取出，上面记录尾结点时会出错
            queue.pop();
        }
        return res;
    }
}
