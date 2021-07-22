package LeetCode;

/**
 * @author Struggle
 * @date Created in 10:33 2019/10/25
 * description Swap Nodes in Pairs  交换链表两个节点的值
 **/
public class Question024 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next.next;
        head = swapTwoNode(head);
        head.next.next = swapPairs(p);
        return head;
    }

    public ListNode swapTwoNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head.next;
        head.next = p.next;
        p.next = head;
        return p;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(6);
        ListNode f = new ListNode(8);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        Question024 q = new Question024();
        ListNode p = q.swapPairs(a);
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
