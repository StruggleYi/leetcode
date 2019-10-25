/**
 * @author Struggle
 * @date Created in 15:47 2019/10/21
 * description 两个倒序的数字相加, 数字由链表构成
 **/

public class Question2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int k = 0;
        ListNode pre = null;
        ListNode res = l1;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + k;
            k = sum / 10;
            l1.val = sum % 10;
            pre = l1;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l2 != null && pre != null) {
            pre.next = l2;
            l1 = l2;
        }
        while (l1 != null && k != 0) {
            int sum = l1.val + k;
            k = sum / 10;
            l1.val = sum % 10;
            pre = l1;
            l1 = l1.next;
        }
        if (k != 0) {
            pre.next = new ListNode(k);
        }
        return res;
    }

    public static void main(String[] args) {
        Question2 q = new Question2();
        ListNode a = new ListNode(8);
        ListNode b = new ListNode(9);
        ListNode c = new ListNode(9);
        ListNode d = new ListNode(2);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(6);
        a.next = b;
        b.next = c;
        //d.next = e;
        e.next = f;
        ListNode result = q.addTwoNumbers(a, d);
        while (result != null) {
            System.out.print(result.val);
            result = result.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
