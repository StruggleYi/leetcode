/**
 * @author Struggle
 * @date Created in 12:49 2021/3/26
 * description Shortest Palindrome 给定字符串s, 在其左边添加字符使得新字符串满足回文规则, 返回最短满足要求的字符串
 * node: 最终目的：寻找最长的回文左子串, 随后在字符串s的左边添加剩余部分的翻转即可满足要求
 * path: https://leetcode.com/problems/shortest-palindrome/
 * level: hard
 **/
public class Question214 {

    /**
     * LeetCode 借鉴解法
     * @param s
     * @return
     */
    public String shortestPalindrome(String s) {
        int i = 0;
        // i记录从字符串从右往左相同字符的个数, n为字符串的长度
        // 最极端的情况，如果字符串s满足回文, 则i的长度为字符串的长度
        // 这里有一个很重要的点, 满足回文条件的字符串一定是在(0,i)的子串当中
        // 假设上面的条件不满足, 则回文条件的字符串在(0,k)的子串当中, 其中k > i
        // 即使在(k,n)之间不满足i与j指向相同的字符,最终i的值是会走到上述所得i之后的,即相互矛盾
        // 可能表述的不是很明确
        // 简而言之:
        //      如果(0,m)的子串满足回文, 且(m,n)之间也有一些i与j指向相同的字符,那么i的值会大于m
        //      则可以缩小返回，在(0,m)的子串中继续进行遍历
        //      最终可以找出最长回文子串
        for(int j = s.length()-1; j >= 0; j--) {
            if(s.charAt(i) == s.charAt(j)) {
                i++;
            }
        }
        if(i == s.length()) {
            return s;
        }
        StringBuilder str = new StringBuilder(s.substring(i));
        str.reverse();
        // 将i后面的字符串进行翻转, 加到中间要继续遍历求得最长回文子串中, 最后加上i后面的字符串
        str.append(shortestPalindrome(s.substring(0, i)) + s.substring(i));
        return str.toString();
    }

    /**
     * 暴力解法，从中间点开始往左递推，找到第一个点，满足点左边的字符与右边字符所对称
     * @param s
     * @return
     */
    public String shortestPalindrome2(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        int k = (len - 1) / 2;
        while (k >= 0) {
            if (s.charAt(k) == s.charAt(k + 1)) {
                String s1 = new StringBuffer(s.substring(0, k + 1)).reverse().toString();
                String s2 = s.substring(k + 1, 2 * k + 2);
                if (s1.equals(s2)) {
                    return new StringBuffer(s.substring(k + 1)).reverse().toString() + s2;
                }
            }
            if (k > 0) {
                String s1 = new StringBuffer(s.substring(0, k)).reverse().toString();
                String s2 = s.substring(k + 1, 2 * k + 1);
                if (s1.equals(s2)) {
                    return new StringBuffer(s.substring(k + 1)).reverse().toString() + s.substring(k);
                }
            }
            k--;
        }
        return new StringBuffer(s.substring(1)).reverse().toString() + s;
    }

    public static void main(String[] args) {
        Question214 q = new Question214();
        System.out.println(q.shortestPalindrome("aacecaaa"));
    }
}
