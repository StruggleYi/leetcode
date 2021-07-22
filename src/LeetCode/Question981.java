package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 17:01 2021/7/10
 * description 基于时间的键值存储
 * node: 注意本题的get 不涉及到删除
 * path: https://leetcode-cn.com/problems/time-based-key-value-store/
 * level: medium
 **/
public class Question981 {
    /**
     * Initialize your data structure here.
     */
    private Map<String, Map<Integer, String>> map;
    private Map<String, List<Integer>> timeMap;

    /**
     * 两个map, 一个记录value 一个记录time的排序关系
     */
    public void TimeMap() {
        map = new HashMap<>();
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        Map<Integer, String> keyMap = map.getOrDefault(key, new HashMap<>());
        keyMap.put(timestamp, value);
        map.put(key, keyMap);

        List<Integer> list = timeMap.getOrDefault(key, new ArrayList<>());
        list.add(timestamp);
        timeMap.put(key, list);
    }

    /**
     * 先判断有没有该key, 有的话去timeMap找出满足要求的timeMap, 然后取出其值即可
     * 本题的time是严格单增的, 所以这里可以使用二分法去求得满足要求的时间
     *
     * @param key
     * @param timestamp
     * @return
     */
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        Map<Integer, String> keyMap = map.get(key);
        List<Integer> list = timeMap.get(key);

        Integer index = findIndex(list, timestamp);
        if (index == -1) {
            return "";
        }

        return keyMap.get(list.get(index));
    }

    private Integer findIndex(List<Integer> list, int timestamp) {
        if (timestamp < list.get(0)) {
            return -1;
        }

        int low = 0;
        int high = list.size() - 1;
        int k = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (list.get(mid) == timestamp) {
                return mid;
            } else if (list.get(mid) > timestamp) {
                high = mid - 1;
            } else {
                low = mid + 1;
                k = mid;
            }
        }

        return k;
    }

    public static void main(String[] args) {
        Question981 q = new Question981();
        q.TimeMap();
        q.set("foo", "bar", 1);
        System.out.println(q.get("foo", 1));
        System.out.println(q.get("foo", 3));
        q.set("foo", "bar2", 4);
        System.out.println(q.get("foo", 4));
        System.out.println(q.get("foo", 5));

    }
}
