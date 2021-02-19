import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 22:22 2021/2/17
 * description Shortest Distance to a Character
 * node:
 * path: https://leetcode.com/problems/shortest-distance-to-a-character/
 * level: easy
 **/
public class Question821 {
    public int[] shortestToChar(String S, char C) {
        int[] res = new int[S.length()];

        int m = -100000;
        int n = S.indexOf(C);

        int i = 0;
        while (i < S.length()) {
            res[i] = Math.min(i - m, n - i);

            if (i == n && i + 1 < S.length()) {
                m = n;
                n = S.substring(m + 1).indexOf(C) + m + 1;
                if (n == m) {
                    n = 100000;
                }
            }
            i++;
        }

        return res;
    }

    public static void main(String[] args) {
        Question821 q = new Question821();

        System.out.println(Arrays.toString(q.shortestToChar("aaab", 'b')));
    }
}
