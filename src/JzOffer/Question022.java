package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:39 2021/5/31
 * description 链表中倒数第k个节点
 * node: 先往前走k个节点, 然后前后同时走到最后就好了
 * path: https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * level: easy
 **/
public class Question022 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p = head;

        while (k-- > 0) {
            p = p.next;
        }

        while (p != null) {
            p = p.next;
            head = head.next;
        }

        return head;
    }

}
