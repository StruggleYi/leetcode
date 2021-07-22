package JzOffer;

/**
 * @author Struggle
 * @date Created in 22:18 2021/7/22
 * description 两个链表的第一个公共节点
 * node:
 * path: https://leetcode-cn.com/problems/liang-ge-lian-biao-de-di-yi-ge-gong-gong-jie-dian-lcof/
 * level: easy
 **/
public class Question052 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        int lenB = 0;

        ListNode p = headA;
        ListNode q = headB;
        while (p != null) {
            lenA++;
            p = p.next;
        }

        while (q != null) {
            lenB++;
            q = q.next;
        }

        if (lenA > lenB) {
            while (lenA > lenB) {
                headA = headA.next;
                lenA--;
            }
        } else {
            while (lenA < lenB) {
                headB = headB.next;
                lenB--;
            }
        }

        while (headA != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }
}
