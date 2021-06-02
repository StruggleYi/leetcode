package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:04 2021/6/2
 * description 合并两个排序的链表  输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的
 * node:
 * path: https://leetcode-cn.com/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 * level: easy
 **/
public class Question025 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head;

        while (l1 != null && l2 != null){
            if (l1.val < l2.val){
                p.next = l1;
                l1 = l1.next;
            }else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }

        if (l1 != null){
            p.next = l1;
        }

        if (l2 != null){
            p.next = l2;
        }

        return head.next;
    }

}
