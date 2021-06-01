package JzOffer;

/**
 * @author Struggle
 * @date Created in 23:50 2021/6/1
 * description 反转链表
 * node:
 * path: https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof/
 * level: easy
 **/
public class Question024 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode p = newHead.next;
        while (p.next != null) {
            ListNode q = p.next;
            p.next = q.next;
            q.next = newHead.next;
            newHead.next = q;
        }

        return newHead.next;
    }
}
