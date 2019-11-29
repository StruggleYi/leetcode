import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 10:28 2019/11/29
 * description Path Sum II 求出二叉树所有根节点到叶节点和为sum的路径
 * path: https://leetcode.com/problems/path-sum-ii/description/
 * level: medium
 **/
public class Question113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null){
            return new ArrayList<>();
        }

        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        int k = 0;
        while (root != null || !stack.isEmpty()){
            while (root != null){
                list.add(root.val);
                k += root.val;
                stack.add(root);
                root = root.left;
            }


        }
        return lists;
    }

    public static void main(String[] args) {

    }
}
