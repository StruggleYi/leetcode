package Interview;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 16:27 2021/7/18
 * description 变位词组  编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串  不考虑答案输出的顺序
 * node:
 * path: https://leetcode-cn.com/problems/group-anagrams-lcci/
 * level: medium
 **/
public class Question010_02 {

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String tmp = new String(array);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                res.add(list);
                map.put(tmp, list);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question010_02 q = new Question010_02();
        String[] strs = {"eat", "tea", "tan", "ate", "nat"};
        List<List<String>> lists = q.groupAnagrams(strs);
        for (List<String> list : lists) {
            System.out.println(list.toString());
        }
    }
}
