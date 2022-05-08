package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:41 2021/8/21
 * description 反转字符串 II
 * node: 按规则翻转即可
 * path: https://leetcode-cn.com/problems/reverse-string-ii
 * level: easy
 **/
public class Question541 {

    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; i += 2 * k) {
            reverse(arr, i, Math.min(i + k, n) - 1);
        }
        return new String(arr);
    }

    public void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }
}
