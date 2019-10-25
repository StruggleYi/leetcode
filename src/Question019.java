/**
 * @author Struggle
 * @date Created in 15:50 2019/10/23
 * description  Remove Nth Node From End of List  移除链表中倒数第n个节点
 **/
public class Question019 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = new ListNode(0);
        p.next = head;
        while (n-- >= 0) {
            p = p.next;
        }
        ListNode q = head;
        if (p == null) {
            return head.next;
        }

        while (p.next != null) {
            q = q.next;
            p = p.next;
        }
        if (q.next != null) {
            q.next = q.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Question019 q = new Question019();
        ListNode head = new ListNode(1);
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(3);
        ListNode c = new ListNode(4);
        ListNode d = new ListNode(5);
        head.next = a;
        a.next = b;
        b.next = c;
        c.next = d;
        ListNode p = q.removeNthFromEnd(head, 2);
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
