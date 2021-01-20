import java.util.*;

/**
 * @author Struggle
 * @date Created in 21:00 2021/1/20
 * description Uncommon Words from Two Sentences 给定两个句子, 求两个句子中只出现一次的单词, 在同一个句子出现多次也不可以
 * node: map 遍历统计两个句子出现词的个数即可
 * path: https://leetcode.com/problems/uncommon-words-from-two-sentences/
 * level: easy
 **/
public class Question884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] stringA = A.split(" ");
        String[] stringB = B.split(" ");

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : stringA){
            if (hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s) + 1);
            }else {
                hashMap.put(s, 1);
            }
        }

        for (String s : stringB){
            if (hashMap.containsKey(s)){
                hashMap.put(s, hashMap.get(s) + 1);
            }else {
                hashMap.put(s, 1);
            }
        }

        List<String> list = new ArrayList<>();

        for(Map.Entry<String, Integer> entry : hashMap.entrySet()){
            if (entry.getValue() == 1){
                list.add(entry.getKey());
            }
        }

        return list.toArray(new String[list.size()]);
    }

    public static void main(String[] args) {
        Question884 q = new Question884();
        String a = "apple apple";
        String b = "banana";
        System.out.println(Arrays.toString(q.uncommonFromSentences(a, b)));
    }
}
