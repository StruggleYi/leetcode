/**
 * @author Struggle
 * @date Created in 8:54 2019/10/23
 * description    Merge k Sorted Lists   合并K个链表
 **/
public class Question023 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }

        return dividedMerge(lists, 0, lists.length - 1);
    }

    public ListNode dividedMerge(ListNode[] lists, int i, int j) {
        if (i == j) {
            return lists[i];
        }

        ListNode left = dividedMerge(lists, i, (i + j) / 2);
        ListNode right = dividedMerge(lists, (i + j) / 2 + 1, j);
        ListNode p = new ListNode(0);
        ListNode q = p;
        while (left != null || right != null) {
            if (left != null && right != null) {
                if (left.val < right.val) {
                    q.next = left;
                    left = left.next;
                } else {
                    q.next = right;
                    right = right.next;
                }
            } else if (left != null) {
                q.next = left;
                left = left.next;
            } else {
                q.next = right;
                right = right.next;
            }
            q = q.next;
        }
        return p.next;
    }

    public static void main(String[] args) {
        Question023 q = new Question023();
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(5);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(2);
        ListNode h = new ListNode(6);

        a.next = b;
        b.next = c;

        d.next = e;
        e.next = f;

        g.next = h;
        ListNode[] listNodes = {a, d, g};
        ListNode p = q.mergeKLists(listNodes);
        while (p != null) {
            System.out.print(p.val);
            p = p.next;
        }
    }
}
