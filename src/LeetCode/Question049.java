package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 17:03 2019/11/1
 * description Group Anagrams 给定一个字符串集合, 将字符相同但顺序不同的字符串挑出放到一起, 然后讲结果输出
 * note: 讲字符串转化为一个可以比较的数组, 然后判断数组是否相同就好, 可以提高字符串比较的速度
 *       Arrays.hashCode 该方法比字符串比较快一些
 * path: https://leetcode.com/problems/group-anagrams/description/
 * level: medium
 **/
public class Question049 {
    public List<List<String>> groupAnagrams(String[] strs){
        List<List<String>> lists = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs){
            int[] num = new int[26];
            for (int i = 0; i < s.length(); i ++){
                num[s.charAt(i)-'a']++;
            }
            int ss = Arrays.hashCode(num);
            List<String> list;
            if (map.containsKey(ss)){
                list = map.get(ss);
            }else {
                list = new ArrayList<>();
            }
            list.add(s);
            map.put(ss, list);
        }
        for (Map.Entry<Integer, List<String>> entry : map.entrySet()){
            lists.add(entry.getValue());
        }
        return lists;
    }

    public static void main(String[] args) {
        Question049 q = new Question049();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = q.groupAnagrams(strs);
        for (List<String> list : lists){
            System.out.println(list.toString());
        }
    }
}
