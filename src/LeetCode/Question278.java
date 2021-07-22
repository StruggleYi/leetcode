package LeetCode;

/**
 * @author Struggle
 * @date Created in 0:20 2021/6/13
 * description 第一个错误的版本 给定一系列版本号 1-> n 其中版本号可能从k开始出错, 那么k之后的版本号均会出错
 * 判断出错的函数可以假定为bool isBadVersion(version)函数, 尽可能少的使用该函数进行判断
 * node: 二叉查找即可
 * path: https://leetcode-cn.com/problems/first-bad-version/
 * level: easy
 **/
public class Question278 {

    /**
     * 二分查找
     *
     * @param n
     * @return
     */
    public int firstBadVersion(int n) {
        int i = 1, j = n;
        int wrong = 0;
        while (i <= j) {
            int mid = i + (j - i) / 2;

            if (isBadVersion(mid)) {
                wrong = mid;
                j = mid - 1;
            } else {
                i = mid + 1;
            }
        }

        return wrong;
    }

    public boolean isBadVersion(int version) {
        return true;
    }
}
