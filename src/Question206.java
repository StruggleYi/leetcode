/**
 * @author Struggle
 * @date Created in 14:47 2019/10/30
 * description Reverse Linked List  链表翻转使用迭代或者递归
 **/
public class Question206 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = new ListNode(0);
        p.next = head;
        ListNode q = head.next;
        head.next = null;
        while (q != null){
            ListNode r = p.next;
            p.next = q;
            q = q.next;
            p.next.next = r;
        }
        return p.next;
    }

    //递归版本
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);
        ListNode q = p;
        while (q.next != null) {
            q = q.next;
        }
        q.next = head;
        head.next = null;
        return p;
    }

    public static void main(String[] args) {
        Question206 q = new Question206();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        a = q.reverseList(a);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
