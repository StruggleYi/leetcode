package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:40 2022/5/15
 * description 删列造序 返回列不是按照升序的数目
 * node: 按序遍历即可
 * path: https://leetcode.cn/problems/delete-columns-to-make-sorted/
 * level: easy
 **/
public class Question944 {

    /**
     * 常规做法
     *
     * @param strs 字符串
     * @return result
     */
    public int minDeletionSize(String[] strs) {
        int count = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            char pre = 'a';
            for (String str : strs) {
                if (pre > str.charAt(i)) {
                    count++;
                    break;
                }
                pre = str.charAt(i);
            }
        }

        return count;
    }

    /**
     * 借鉴的更快的方法
     *
     * @param strs 字符串
     * @return result
     */
    public int minDeletionSize2(String[] strs) {

        int result = 0;
        if (strs.length == 0) {
            return result;
        }
        int len = strs[0].length();
        for (int i = 0; i < len; i++) {
            result += help(strs, i);
        }
        return result;
    }

    private int help(String[] strs, int i) {
        char last = strs[0].charAt(i);
        for (int j = 1; j < strs.length; j++) {
            // 将第二个字符串的每一个字符拿出来与第一个字符串的字符比较
            char cur = strs[j].charAt(i);
            if (cur < last) {
                return 1;
            }
            last = cur;
        }
        return 0;
    }
}
