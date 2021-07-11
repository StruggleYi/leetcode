/**
 * @author Struggle
 * @date Created in 16:49 2021/7/11
 * description H 指数  h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次
 * node:
 * path: https://leetcode-cn.com/problems/h-index/
 * level: medium
 **/
public class Question274 {

    /**
     * 统计引用次数对应的文章数, 随后从高到低判断H指数是否满足要求
     *
     * @param citations
     * @return
     */
    public int hIndex(int[] citations) {

        int n = citations.length;
        int[] dp = new int[n + 1];

        // H的最大值为文章的个数, 如果引用个数大于文章数, 取文章数即可
        for (int k : citations) {
            k = Math.min(k, n);
            dp[k]++;
        }

        // 从高到低遍历并累计文章数, 直到H满足要求
        int k = 0;
        for (int i = n; i > 0; i--) {
            k += dp[i];
            if (k >= i) {
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Question274 q = new Question274();
        int[] citations = {3, 0, 6, 1, 5};
        System.out.println(q.hIndex(citations));
    }
}
