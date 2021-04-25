package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:11 2021/4/25
 * description 从尾到头打印链表
 * node: 注意链表长度可能为0的情况
 * path: https://leetcode-cn.com/problems/cong-wei-dao-tou-da-yin-lian-biao-lcof/
 * level: easy
 **/


public class Question006 {
    public int[] reversePrint(ListNode head) {
        if (head == null) {
            return new int[0];
        }

        ListNode p = head;
        int len = 0;
        while (p != null) {
            len++;
            p = p.next;
        }

        int[] res = new int[len];
        int i = 0;
        while (head != null) {
            res[len - 1 - i] = head.val;
            head = head.next;
            i++;
        }

        return res;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}