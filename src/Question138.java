/**
 * @author Struggle
 * @date Created in 22:12 2021/7/22
 * description 复制带随机指针的链表
 * node:
 * path: https://leetcode-cn.com/problems/copy-list-with-random-pointer/
 * level: medium
 **/
public class Question138 {

    /**
     * 节点复制, 然后把偶数个抽出来即可
     *
     * @param head
     * @return
     */
    public RandomNode copyRandomList(RandomNode head) {

        if (head == null) {
            return head;
        }

        RandomNode p = head;
        // 节点都复制一遍, 偶数个为复制的节点
        while (p != null) {
            RandomNode r = new RandomNode(p.val);
            r.next = p.next;
            p.next = r;
            p = r.next;
        }

        // 加上random节点的指向关系
        p = head;
        while (p != null) {
            if (p.random == null) {
                p.next.random = null;
            } else {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }

        // 把偶数个节点拆分出来, 构成复制的链表
        p = head;
        RandomNode res = head.next;
        RandomNode q = res;
        while (q.next != null) {
            p.next = p.next.next;
            q.next = q.next.next;
            p = p.next;
            q = q.next;
        }
        p.next = null;

        return res;
    }
}

class RandomNode {
    int val;
    RandomNode next;
    RandomNode random;

    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}