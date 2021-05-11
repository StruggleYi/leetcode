/**
 * @author Struggle
 * @date Created in 2020/11/16 11:19
 * description The kth Factor of n 找出第k个能被n整除的数
 * node: 最基本的做法，遍历即可
 * path: https://leetcode.com/problems/the-kth-factor-of-n/
 * level: medium
 **/
public class Question1492 {
    public int kthFactor(int n, int k) {
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                k--;
            }
            if (k == 0) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Question1492 q = new Question1492();
        System.out.println(q.kthFactor(24, 6));
    }
}

