import java.util.*;

/**
 * @author Struggle
 * @date Created in 21:18 2021/5/20
 * description 前K个高频单词 返回前 k 个出现次数最多的单词 如果不同的单词有相同出现频率，按字母顺序排序
 * node: O(n log k) 时间复杂度和 O(n) 空间复杂度
 * path: https://leetcode-cn.com/problems/top-k-frequent-words/
 * level: medium
 **/
public class Question692 {

    /**
     * leetcode 借鉴做法
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent(String[] words, int k) {
        int len = words.length;
        String[] keys = new String[len];
        int[] values = new int[len];

        for (int i = 0; i < len; i++) {

            // 去掉符号位
            int hash = (words[i].hashCode() & 0x7FFFFFFF) % len;
            // 防止hash冲突
            while (!words[i].equals(keys[hash]) && values[hash] > 0) {
                hash = (hash + 1) % len;
            }
            keys[hash] = words[i];
            values[hash]++;
        }

        // 这里采用优先级队列利用String默认字典序比较器
        PriorityQueue<String>[] counts = new PriorityQueue[len + 1];

        for (int i = 0; i < len; i++) {
            int value = values[i];
            if (value > 0) {
                if (counts[value] == null) {
                    counts[value] = new PriorityQueue<>();
                }
                counts[value].add(keys[i]);
            }
        }

        // 将存有计数信息的数组counts从后向前遍历k个word
        List<String> result = new ArrayList<>(k);
        for (int i = counts.length - 1; i >= 0; i--) {
            PriorityQueue<String> heap = counts[i];
            if (heap != null) {
                while (!heap.isEmpty()) {
                    result.add(heap.poll());
                    k--;
                    if (k == 0) {
                        return result;
                    }
                }
            }
        }
        return result;
    }


    /**
     * 本人做法, 但是时间复杂度不满足题目要求O(n log k)
     * 可以继续优化, 使用优先队列来处理, 具体参考上文
     *
     * @param words
     * @param k
     * @return
     */
    public List<String> topKFrequent2(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        List<Word> wordList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            Word word = new Word();
            word.setName(entry.getKey());
            word.setK(entry.getValue());
            wordList.add(word);
        }

        List<String> res = new ArrayList<>();
        wordList.sort((o1, o2) -> {
            if (o1.getK() > o2.getK()) {
                return -1;
            } else if (o1.getK() < o2.getK()) {
                return 1;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for (int i = 0; i < k; i++) {
            res.add(wordList.get(i).getName());
        }
        return res;
    }

    public static void main(String[] args) {
        Question692 q = new Question692();
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        System.out.println(q.topKFrequent(words, 4));
    }
}

class Word {
    private String name;
    private Integer k;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getK() {
        return k;
    }

    public void setK(Integer k) {
        this.k = k;
    }
}