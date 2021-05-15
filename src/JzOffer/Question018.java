package JzOffer;

/**
 * @author Struggle
 * @date Created in 23:28 2021/5/15
 * description 删除链表的节点
 * node: 遍历即可, 本题所有节点值不重复, 找到一个重复点即可
 * path: https://leetcode-cn.com/problems/shan-chu-lian-biao-de-jie-dian-lcof/
 * level: easy
 **/
public class Question018 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val) {
            return head.next;
        }

        ListNode pre = head;
        ListNode p = head.next;

        while (true) {
            if (p.val == val) {
                pre.next = p.next;
                break;
            }

            pre = p;
            p = p.next;
        }

        return head;
    }
}

