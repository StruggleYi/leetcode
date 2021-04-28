import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 23:32 2021/4/27
 * description
 * node:
 * path:
 * level:
 **/
public class Question938 {

    /**
     * 借鉴使用递归解法
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        } else if (withinRange(low, high, root.val)) {
            return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        } else if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        } else if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        } else {
            return 0;
        }
    }

    private boolean withinRange(int low, int high, int val) {
        return val <= high && val >= low;
    }


    /**
     * 使用栈的解法
     *
     * @param root
     * @param low
     * @param high
     * @return
     */
    public int rangeSumBST2(TreeNode root, int low, int high) {
        int sum = 0;

        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();

            if (p.val >= low && p.val <= high) {
                sum += p.val;
            }

            if (p.left != null && p.val <= high) {
                stack.add(p.left);
            }
            if (p.right != null && p.val >= low) {
                stack.add(p.right);
            }
        }


        return sum;
    }

}
