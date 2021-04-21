/**
 * @author Struggle
 * @date Created in 22:34 2021/4/21
 * description 实现 strStr() 在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始） 如果不存在，则返回  -1
 * node: KMP算法
 * path: https://leetcode.com/problems/implement-strstr/
 * https://leetcode-cn.com/problems/implement-strstr/
 * level: easy
 **/
public class Question028 {

    /**
     * 借鉴的 kmp算法
     *
     * @param ss
     * @param pp
     * @return
     */
    public int strStr(String ss, String pp) {
        if (pp.isEmpty()) {
            return 0;
        }

        // 分别读取原串和匹配串的长度
        int n = ss.length(), m = pp.length();
        // 原串和匹配串前面都加空格，使其下标从 1 开始
        ss = " " + ss;
        pp = " " + pp;

        char[] s = ss.toCharArray();
        char[] p = pp.toCharArray();

        // 构建 next 数组，数组长度为匹配串的长度（next 数组是和匹配串相关的）
        int[] next = new int[m + 1];
        // 构造过程 i = 2，j = 0 开始，i 小于等于匹配串长度 【构造 i 从 2 开始】
        for (int i = 2, j = 0; i <= m; i++) {
            // 匹配不成功的话，j = next(j)
            while (j > 0 && p[i] != p[j + 1]) j = next[j];
            // 匹配成功的话，先让 j++
            if (p[i] == p[j + 1]) j++;
            // 更新 next[i]，结束本次循环，i++
            next[i] = j;
        }

        // 匹配过程，i = 1，j = 0 开始，i 小于等于原串长度 【匹配 i 从 1 开始】
        for (int i = 1, j = 0; i <= n; i++) {
            // 匹配不成功 j = next(j)
            while (j > 0 && s[i] != p[j + 1]) {
                j = next[j];
            }
            // 匹配成功的话，先让 j++，结束本次循环后 i++
            if (s[i] == p[j + 1]) j++;
            // 整一段匹配成功，直接返回下标
            if (j == m) {
                return i - m;
            }
        }

        return -1;
    }

    public int strStr2(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        int len = haystack.length();
        int k = needle.length();
        for (int i = 0; i <= len - k; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                String s = haystack.substring(i, i + k);
                if (s.equals(needle)) {
                    return i;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Question028 q = new Question028();
        System.out.println(q.strStr("hello", "lo"));
    }
}
