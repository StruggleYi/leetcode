package JzOffer;

import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 23:01 2021/6/16
 * description 二叉搜索树与双向链表 将一颗二叉搜索树转换成排序的循环双链表, 不能创建新节点
 * node: 按照中序遍历排序, Node2 的原因在于 Node 在 35题已经使用过, 这里用 Node2 代替
 * path: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/
 * level: medium
 **/
public class Question036 {


    Node2 p1, p2;

    /**
     * 递归做法
     */
    public Node2 treeToDoublyList(Node2 root) {
        if (root == null) {
            return null;
        }
        dfs(root);
        p2.right = p1;
        p1.left = p2;
        return p1;
    }

    public void dfs(Node2 root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (p1 == null) {
            p1 = root;
        } else {
            p2.right = root;
        }
        root.left = p2;
        p2 = root;

        dfs(root.right);
    }

    /**
     * 非递归做法
     *
     * @param root
     * @return
     */
    public Node2 treeToDoublyList2(Node2 root) {

        if (root == null) {
            return root;
        }

        Stack<Node2> stack = new Stack<>();

        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        Node2 head = stack.peek();
        Node2 pre = null;
        Node2 tail = head;

        while (!stack.isEmpty()) {
            Node2 p = stack.pop();

            Node2 q = p.right;
            while (q != null) {
                stack.push(q);
                q = q.left;
            }

            if (!stack.isEmpty()) {
                p.right = stack.peek();
            }
            p.left = pre;
            tail = p;
            pre = p;
        }

        head.left = tail;
        tail.right = head;

        return head;
    }
}

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {
    }

    public Node2(int val) {
        val = val;
    }

    public Node2(int val, Node2 left, Node2 right) {
        val = val;
        left = left;
        right = right;
    }
}

