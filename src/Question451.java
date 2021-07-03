import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 15:15 2021/7/3
 * description  根据字符出现频率排序  给定一个字符串，请将字符串里的字符按照出现的频率降序排列
 * node:
 * path: https://leetcode-cn.com/problems/sort-characters-by-frequency/
 * level: medium
 **/
public class Question451 {

    /**
     * 简便方式
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        int[][] cnts = new int[128][2];
        char[] cs = s.toCharArray();
        for (int i = 0; i < 128; i++) {
            cnts[i][0] = i;
        }
        for (char c : cs) {
            cnts[c][1]++;
        }
        Arrays.sort(cnts, (a, b) -> {
            if (a[1] != b[1]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            char c = (char) cnts[i][0];
            int k = cnts[i][1];
            while (k-- > 0) {
                sb.append(c);
            }
        }
        return sb.toString();
    }


    /**
     * 原始方式
     *
     * @param s
     * @return
     */
    public String frequencySort2(String s) {

        int len = s.length();

        if (len <= 2) {
            return s;
        }

        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);

            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        String[] strings = new String[len + 1];
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int k = entry.getValue();
            char c = entry.getKey();

            strings[k] = (strings[k] == null ? "" : strings[k]);
            int i = k;
            while (i-- > 0) {
                strings[k] += c;
            }
        }

        StringBuilder res = new StringBuilder();
        for (int i = len; i > 0; i--) {
            if (strings[i] != null) {
                res.append(strings[i]);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Question451 q = new Question451();
        System.out.println(q.frequencySort("accaa"));
    }
}
