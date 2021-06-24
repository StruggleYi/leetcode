import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 22:28 2021/6/22
 * description 字符串的排列 输入一个字符串，打印出该字符串中字符的所有排列, 输出不允许重复
 * node:
 * path: https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/
 * level: medium
 **/
public class Question038 {
    Set<String> set = new HashSet<>();

    public String[] permutation(String s) {

        char[] chars = s.toCharArray();
        dfs(chars, 0);

        String[] res = new String[set.size()];
        int i = 0;
        for (String s1 : set) {
            res[i++] = s1;
        }

        return res;
    }

    private void dfs(char[] chars, int i) {
        if (i == chars.length) {
            return;
        }

        for (int j = i + 1; j < chars.length; j++) {
            swap(chars, i, j);
            dfs(chars, i + 1);
            set.add(String.valueOf(chars));
            swap(chars, i, j);
        }
        set.add(String.valueOf(chars));
        dfs(chars, i + 1);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }
}
