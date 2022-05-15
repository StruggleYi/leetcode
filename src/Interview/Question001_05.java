package Interview;

/**
 * @author Struggle
 * @date Created in 21:31 2022/5/15
 * description 一次编辑 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑
 * node: 按照不同情况分析
 * path: https://leetcode.cn/problems/one-away-lcci/
 * level: medium
 **/
public class Question001_05 {

    public boolean oneEditAway(String first, String second) {
        // 编辑的方式包含三种：插入、删除、替换
        // 1、字符串长度大于1, 插入, 从头开始遍历第一个不一样的字符, 在后面插入
        // 2、字符串的长度小于1, 删除, 从头开始遍历第一个不一样的字符, 删除
        // 3、字符串的长度相同, 替换, 从头开始遍历第一个不一样的字符, 替换

        int len1 = first.length();
        int len2 = second.length();
        if (Math.abs(len1 - len2) > 1) {
            return false;
        }

        boolean flag = false;
        for (int i = 0, j = 0; i < len1 && j < len2; i++, j++) {
            if (first.charAt(i) == second.charAt(j)) {
                continue;
            }

            // 第二次出现不相同, 直接返回 false
            if (flag) {
                return false;
            }

            // 标记已经出现过不同
            flag = true;
            if (len1 < len2) {
                i--;
            } else if (len1 > len2) {
                j--;
            }
        }

        return true;
    }
}
