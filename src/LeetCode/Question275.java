package LeetCode;

/**
 * @author Struggle
 * @date Created in 21:13 2021/7/12
 * description H 指数 II 给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列, 计算出研究者的 h 指数
 * node:
 * path: https://leetcode-cn.com/problems/h-index-ii/
 * level: medium
 **/
public class Question275 {

    /**
     * 二分法
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {
        int n = citations.length;
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (citations[mid] >= n - mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return citations[r] >= n - r ? n - r : 0;
    }


    public int hIndex2(int[] citations) {
        int n = citations.length;

        int h = Math.min(n, citations[n - 1]);
        int k = 0;
        n--;
        while (n >= 0) {
            if (k >= h) {
                return h;
            }

            if (citations[n] < h) {
                h--;
            } else {
                n--;
                k++;
            }
        }

        return h;
    }

}
