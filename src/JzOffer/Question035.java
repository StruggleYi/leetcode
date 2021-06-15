package JzOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 21:21 2021/6/15
 * description 复杂链表的复制  请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null
 * node: 注意本题原链表的结构最后不能进行改变, 需要还原
 * path: https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof/
 * level: medium
 **/
public class Question035 {

    /**
     * 先依次复制节点, 然后复制节点的random关系, 最后链表分离
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return head;
        }

        Node p = head;
        // 节点都复制一遍, 偶数个为复制的节点
        while (p != null) {
            Node r = new Node(p.val);
            r.next = p.next;
            p.next = r;
            p = r.next;
        }

        // 加上random节点的指向关系
        p = head;
        while (p != null) {
            if (p.random == null) {
                p.next.random = null;
            } else {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 把偶数个节点拆分出来, 构成复制的链表
        p = head;
        Node res = head.next;
        Node q = res;
        while (res.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        p.next = null;

        return res;
    }

    /**
     * 最初的方法一: 记录原链表中random所指向的位置, 便于新链表还原random的指向
     *
     * @param head
     * @return
     */
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return head;
        }

        Node newHead = new Node(0);

        Node p = head;
        Node q = newHead;

        // map记录原链表各节点的位置, newMap记录新链表各位置下的节点
        Map<Node, Integer> map = new HashMap<>();
        Map<Integer, Node> newMap = new HashMap<>();
        int i = 1;

        // 构建新链表
        while (p != null) {
            map.put(p, i);
            Node r = new Node(p.val);
            newMap.put(i++, r);
            p = p.next;
            q.next = r;
            q = r;
        }

        p = head;
        q = newHead.next;

        // 根据记录下的random的指向位置, 对新链表的random指向进行还原
        while (p != null) {
            Node r = p.random;

            if (r == null) {
                q.random = null;
            } else {
                q.random = newMap.get(map.get(r));
            }

            p = p.next;
            q = q.next;
        }

        return newHead.next;
    }


    public static void main(String[] args) {
        Question035 q = new Question035();
        Node p1 = new Node(1);
        Node p2 = new Node(2);
        Node p3 = new Node(3);
        Node p4 = new Node(4);
        p1.random = null;
        p2.random = p4;
        p3.random = p1;
        p4.random = p2;
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;

        p1 = q.copyRandomList(p1);
        while (p1 != null) {
            System.out.println(p1.val + "  " + (p1.random == null ? " " : p1.random.val));
            p1 = p1.next;
        }
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
