/**
 * @author Struggle
 * @date Created in 11:18 2019/10/30
 * description  Remove Linked List Elements  移除链表中所有值为k的数
 **/
public class Question203 {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null){
            return head;
        }

        ListNode p = removeElements(head.next, val);
        if (head.val == val){
            return p;
        }else {
            head.next = p;
            return head;
        }
    }

    public static void main(String[] args) {
        Question203 q = new Question203();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(6);
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(5);
        ListNode g = new ListNode(6);

        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;

        a = q.removeElements(a, 6);

        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
