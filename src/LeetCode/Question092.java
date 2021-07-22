package LeetCode;

/**
 * @author Struggle
 * @date Created in 16:01 2019/11/26
 * description 将链表的第m-n部分进行翻转, 只进行一次遍历
 * note: 先找到第m个位置的节点, 依次翻转即可.
 * path: https://leetcode.com/problems/reverse-linked-list-ii/description/
 * level: medium
 **/
public class Question092 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode p = head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode pd = pre;

        //找到第m个节点p
        while (--m > 0){
            p = p.next;
            pre = pre.next;
            --n;
        }

        //翻转链表
        while (--n > 0){
            ListNode q = p.next;
            p.next = q.next;
            q.next = pre.next;
            pre.next = q;
        }
        return pd.next;
    }

    public static void main(String[] args) {
        Question092 q = new Question092();
        ListNode a = new ListNode(5);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;

        ListNode p  = q.reverseBetween(a, 1, 2);
        while (p != null){
            System.out.println(p.val);
            p = p.next;
        }
    }
}
