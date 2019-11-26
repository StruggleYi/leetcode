import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 17:00 2019/11/25
 * description LFU Cache 最近最不常用置换, 缓存容量如果满了, 将最近最不常用的移除  时间复杂度o(1)
 * path: https://leetcode.com/problems/lfu-cache/
 * level: hard
 **/
public class Question460 {

    int size;
    int min = 0;


    /**
     *  map 用来存k-v键值对
     *  freMap 用来存出现的频率以及对应的key
     *  countMap 用来统计key对应的频率
     *  这里使用LinkedHashSet 的原因是: 可以保证存取的顺序一致, 可以直接取出set中的第一个数, 则代表是最不常用的数字
     */
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, LinkedHashSet<Integer>> freMap = new HashMap<>();
    Map<Integer, Integer> countMap = new HashMap<>();

    public void LFUCache(int capacity) {
        size = capacity;
        freMap.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        // 不包含key 则返回-1
        if (!map.containsKey(key)) {
            return -1;
        }

        // 频率+1, 并将该key从原有的freMap 中移除
        int count = countMap.get(key);
        countMap.put(key, count + 1);
        freMap.get(count).remove(key);

        // 如果所有数字出现的频率均大于最小值, 则将最小值+1
        if (min == count && freMap.get(count).size() == 0) {
            min++;
        }

        // 将freMap更新, 将该key移到频率+1的位置
        if (!freMap.containsKey(count + 1)){
            freMap.put(count + 1, new LinkedHashSet<>());
        }
        freMap.get(count + 1).add(key);
        return map.get(key);
    }

    public void put(int key, int value) {
        if (size <= 0){
            return;
        }

        // 重复出现则更新
        if (map.containsKey(key)){
            map.put(key, value);
            //这里直接调用get 相当于频率+1, 简化操作
            get(key);
            return;
        }

        // 内存已满, 则移除最近最不常用的数字, set中的第一个即为最不常用的数字
        if (map.size() >= size){
            int k = freMap.get(min).iterator().next();
            freMap.get(min).remove(k);
            map.remove(k);
        }

        // 将新的k-v插入到对应的三个map当中
        min = 1;
        map.put(key, value);
        freMap.get(1).add(key);
        countMap.put(key, 1);
    }


    public static void main(String[] args) {
        Question460 q = new Question460();
        q.LFUCache(2);
        q.put(1, 1);
        q.put(2, 2);
        System.out.println(q.get(1));
        q.put(3, 3);
        System.out.println(q.get(2));
        System.out.println(q.get(3));
        q.put(4, 4);
        System.out.println(q.get(1));
        System.out.println(q.get(3));
        System.out.println(q.get(4));
    }
}

