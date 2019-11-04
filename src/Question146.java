import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 16:11 2019/11/4
 * description: LRU Cache 最近最少使用, 时间复杂度o(1)
 * note: map可以保证o(1)的时间复杂度, 但是在保证顺序的过程中也要实现o(1)的时间复杂度, 在这里使用一个双向链表来维持进出的顺序
 *       如果使用List, 时间复杂度为o(n)
 * path: https://leetcode.com/problems/lru-cache/description/
 * level: hard
 **/
public class Question146 {

    int k;
    private Map<Integer, Node> map = new HashMap<>();
    private Node head, tail;
    /**
     * 在线测试的时候去掉 void
     * note: map可以保证o(1)的时间复杂度, 但是在保证顺序的过程中也要实现o(1)的时间复杂度, 在这里使用一个双向链表来维持进出的顺序
     *       如果使用List, 时间复杂度为o(n)
     */
    public void LRUCache(int capacity) {
        k = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.pre = head;
    }

    public void addNode(Node p){
        Node q = tail.pre;
        q.next = p;
        tail.pre = p;
        p.pre = q;
        p.next = tail;
    }

    public void deleteNode(Node p){
        Node pre = p.pre;
        p = p.next;
        pre.next = p;
        p.pre = pre;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node p = map.get(key);
            deleteNode(p);
            addNode(p);
            return p.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.size() == k && !map.containsKey(key)){
            map.remove(head.next.key);
            deleteNode(head.next);
        }
        Node p = new Node(key, value);
        if (map.containsKey(key)){
            deleteNode(map.get(key));
        }
        addNode(p);
        map.put(key, p);
    }

    public static void main(String[] args) {
        //未写测试用例, 通过在线测试
    }
}

class Node {
    int key;
    int value;
    Node pre;
    Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
