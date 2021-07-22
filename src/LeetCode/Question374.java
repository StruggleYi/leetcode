package LeetCode;

/**
 * @author Struggle
 * @date Created in 11:57 2021/3/28
 * description Guess Number Higher or Lower 猜数字大小
 * node: 注：下面折半查找时, i + j 可能越界
 * path: https://leetcode.com/problems/guess-number-higher-or-lower/
 * level: easy
 **/
public class Question374 {

    public int guessNumber(int n) {
        long i = 1, j = n;
        while (i <= j) {
            int mid = (int)((i + j) / 2);
            if (guess(mid) == 0) {
                return mid;
            } else if (guess(mid) > 0) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return 1;
    }

    /**
     * 预设的一个猜测函数，leetcode帮你判断你猜的数与实际数的返回情况
     *
     * @param num
     * @return
     */
    int guess(int num) {
        int pick = 1702766719;
        if (num == pick) {
            return 0;
        } else if (num > pick) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String[] args) {
        Question374 q = new Question374();
        System.out.println(q.guessNumber(2126753390));
    }
}
