package LeetCode;

/**
 * @author Struggle
 * @date Created in 16:04 2019/10/23
 * description   Reverse Nodes in k-Group  链表中每k个节点进行翻转, 空间复杂度o(1)
 **/
public class Question025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return null;
        }

        ListNode p = head;
        int count = 1;
        while (count < k && p.next != null) {
            count++;
            p = p.next;
        }

        ListNode q = p.next;
        p.next = null;
        if( count == k) {
            head = reverseList(head);
        }
        p = head;
        while (p.next != null){
            p = p.next;
        }
        p.next = reverseKGroup(q, k);

        return head;
    }

    public ListNode reverseList(ListNode p) {
        ListNode head = new ListNode(0);
        while (p != null) {
            ListNode q = head.next;
            head.next = p;
            p = p.next;
            head.next.next = q;
        }
        return head.next;
    }

    public static void main(String[] args) {
        Question025 q = new Question025();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode f = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = f;
        ListNode p = q.reverseKGroup(a, 3);
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
