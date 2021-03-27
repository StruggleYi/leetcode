import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 15:23 2021/3/27
 * description Partition Labels 给定一个字符串S, 尽可能多的将其拆分成多个子串, 使得每个子串中的字符只出现自己的分组里, 一次返回拆分后分组中字符的个数
 * node:
 * path: https://leetcode.com/problems/partition-labels/
 * level: medium
 **/
public class Question763 {


    /**
     * 直接从第一个数开始确认区间范围，如果区间内的数存在字符在区间外，则对区间进行扩充
     *
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        List<Integer> res = new ArrayList<>();

        // 使用第一个字符确认第一个区间
        char c = S.charAt(0);
        int k = S.lastIndexOf(c);
        int i = 1;
        int m = 0;

        while (k < S.length()) {
            // 用于将已经计算过的字符存储下来，避免重复判断
            HashSet<Character> hashSet = new HashSet<>();
            // 遍历区间内所有的字符
            for (; i <= k; i++) {
                if (hashSet.contains(S.charAt(i))){
                    continue;
                }

                int j = S.lastIndexOf(S.charAt(i));
                // 如果区间内有字符在区间外，则将区间范围扩大
                if (j > k){
                    k = j;
                }
                hashSet.add(S.charAt(i));
            }
            res.add(k - m + 1);
            k++;
            m = k;
        }

        return res;
    }

    public static void main(String[] args) {
        Question763 q = new Question763();
        System.out.println(q.partitionLabels("ababcbacadefegdehijhklij").toString());
    }
}
