package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 2024/8/18 17:49
 * description K 周期字符串需要的最少操作次数
 * node: 将字符串按 k 的长度进行拆分，找出出现次数最多的字符串, 操作次数为 总字符串个数 减去 出现次数最多的字符串长度
 * path: https://leetcode.cn/problems/minimum-number-of-operations-to-make-word-k-periodic/?envType=daily-question&envId=2024-08-18
 * level: medium
 **/
public class Question3137 {

    public int minimumOperationsToMakeKPeriodic(String word, int k) {
        int sum = word.length() / k;
        int max = 0;
        Map<String, Integer> countMap = new HashMap<>();
        for (int i = 0; i < sum; i++) {
            String substring = word.substring(i * k, (i + 1) * k);
            int count = countMap.getOrDefault(substring, 0) + 1;
            countMap.put(substring, count);
            max = Math.max(max, count);
        }

        return sum - max;
    }


    public int minimumOperationsToMakeKPeriodic1(String word, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        int max = 1;
        // 做法二： 使用数值计算数量，时间消耗会更小
        for (int i = 0; i < word.length(); i += k) {
            long mask = 0;
            for (int j = i; j < i + k; ++j) {
                mask = mask * 26 + (word.charAt(j) - 'a');
            }
            max = Math.max(max, map.merge(mask, 1, Integer::sum));
        }
        return word.length() / k - max;
    }
}
