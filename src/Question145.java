import java.util.*;

/**
 * @author Struggle
 * @date Created in 17:39 2019/11/1
 * description Binary Tree Postorder Traversal 二叉树后序遍历, 使用非递归算法
 * note: 用一个节点记录前一个遍历的是哪个子节点, 先将右子树压栈, 再添加左子树, 可以保证先访问左子树再访问右子树,
 *       该若为叶子节点或者有一个子节点已经被访问, 则表示输出此节点, 直到栈为空
 * path: https://leetcode.com/problems/binary-tree-postorder-traversal/submissions/
 * level: hard
 **/
public class Question145 {
    /**
     * 递归做法
     */
    List<Integer> list1 = new ArrayList<>();
    public List<Integer> postorderTraversal2(TreeNode root) {
        postOrder(root);
        return list1;
    }

    public void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        list1.add(root.val);
    }

    /**
     * 非递归做法
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        TreeNode pre = new TreeNode(-1);
        while (!stack.isEmpty()) {
            TreeNode p = stack.peek();
            //判断孩子节点是否被访问过
            if (pre == p.left || pre == p.right || (p.left == null && p.right == null)) {
                pre = stack.pop();
                list.add(pre.val);
            } else {
                if (p.right != null) {
                    stack.push(p.right);
                }
                if (p.left != null) {
                    stack.push(p.left);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Question145 q = new Question145();
        TreeNode root = new TreeNode(1);
        TreeNode a = new TreeNode(2);
        TreeNode b = new TreeNode(3);
        root.right = a;
        a.left = b;
        System.out.println(q.postorderTraversal(root).toString());
    }
}
