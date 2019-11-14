/**
 * @author Struggle
 * @date Created in 9:33 2019/11/14
 * description Partition List 给定一个链表以及数字k, 使得小于k的数字保存在大于等于k的数字之前, 保持原有数字的相对顺序
 * note: 使用一个链表将小于k的数提出, 最后将剩余的数加到新链表的后面即可
 * path: https://leetcode.com/problems/partition-list/description/
 * level: medium
 **/
public class Question086 {
    public ListNode partition(ListNode head, int x) {
        if (head == null){
            return head;
        }
        //p遍历原有链表, q为新链表的头结点, newHead保存q最初始的位置
        ListNode p = head;
        ListNode q = new ListNode(0);
        ListNode newHead = q;
        //pre在原有链表的基础上增加一个头结点方便抽出节点, oldHead保存pre最初始的位置
        ListNode pre = new ListNode(0);
        ListNode oldHead = pre;
        pre.next = p;
        while (p != null){
            //小于指定的数字则将其抽出放到新链表中
            if (p.val < x){
                q.next = p;
                q = q.next;
                pre.next = p.next;
                p = pre.next;
            }else {
                pre = p;
                p = p.next;
            }
        }
        q.next = oldHead.next;
        return newHead.next;
    }

    public static void main(String[] args) {
        Question086 q = new Question086();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(2);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        a = q.partition(a, 3);
        while (a != null) {
            System.out.println(a.val);
            a = a.next;
        }
    }
}
