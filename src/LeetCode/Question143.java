package LeetCode;

/**
 * @author Struggle
 * @date Created in 15:24 2021/3/28
 * description Reorder List 重排链表结果, 使得1->n 的顺序变为1,n,2,n-1,...的形式
 * node: 先计算出链表的断开点, 将后半部分的链表提出然后翻转, 最后将两条链表合并即可
 * path: https://leetcode.com/problems/reorder-list/
 * level: medium
 **/
public class Question143 {

    public void reorderList(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        int len = 1;
        // 两个节点同时走, 寻找出需要断开的节点位置
        while (p.next != null) {
            p = p.next;
            if (len % 2 == 0) {
                q = q.next;
            }
            len++;
        }

        if (len <= 2) {
            return;
        }

        // 断开两条链表
        ListNode end = q;
        q = q.next;
        end.next = null;

        ListNode newHead = new ListNode(0);
        newHead.next = q;

        // 翻转后面的链表
        while (q.next != null) {
            ListNode r = q.next;

            q.next = r.next;
            r.next = newHead.next;
            newHead.next = r;
        }


        // 两条链表合并
        newHead = newHead.next;
        while (newHead != null) {
            p = head.next;
            q = newHead.next;

            head.next = newHead;
            newHead.next = p;

            head = p;
            newHead = q;
        }
    }

    public static void main(String[] args) {
        Question143 q = new Question143();

        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;

        q.reorderList(a);
    }
}
