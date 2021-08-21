package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 23:40 2021/8/19
 * description 反转字符串中的元音字母 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串
 * node:
 * path: https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 * level: easy
 **/
public class Question345 {
    public String reverseVowels(String s) {
        Set<Character> set = new HashSet<>();

        // 添加元音字母
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int i = 0, j = s.length() - 1;
        StringBuilder start = new StringBuilder();
        StringBuilder end = new StringBuilder();

        while (i <= j) {
            while (i <= j && !set.contains(s.charAt(i))) {
                start.append(s.charAt(i++));
            }

            while (i <= j && !set.contains(s.charAt(j))) {
                end.append(s.charAt(j--));
            }

            if (i == j){
                start.append(s.charAt(j));
            } else if (i < j) {
                start.append(s.charAt(j));
                end.append(s.charAt(i));
            }
            i++;
            j--;
        }

        return start.append(end.reverse()).toString();
    }
}
