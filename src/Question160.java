/**
 * @author Struggle
 * @date Created in 23:53 2021/6/4
 * description 相交链表
 * node: 先计算两个链表长度, 由于相交后的长度相同, 长的链表先走完距离差, 然后同时向后遍历, 直到节点相同
 * path: https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 * level: easy
 **/
public class Question160 {
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
