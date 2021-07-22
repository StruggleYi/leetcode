package LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 22:07 2021/7/7
 * description 大餐计数  大餐 是指 恰好包含两道不同餐品 的一餐，其美味程度之和等于 2 的幂
 * 给你一个整数数组 deliciousness ，其中 deliciousness[i] 是第 i​​​​​​​​​​​​​​ 道餐品的美味程度，返回你可以用数组中的餐品做出的不同 大餐 的数量。结果需要对 109 + 7 取余
 * node:
 * path: https://leetcode-cn.com/problems/count-good-meals/
 * level: medium
 **/
public class Question1711 {

    /**
     * 运行速度更快的版本
     *
     * @param ds
     * @return
     */
    public int countPairs(int[] ds) {
        int min, max;
        min = max = ds[0];
        for (int v : ds) {
            if (v < min) {
                min = v;
            } else if (v > max) {
                max = v;
            }
        }
        int[] map = new int[max - min + 1];
        long res = 0;
        for (int v : ds) {
            for (int s = 1; ; s <<= 1) {
                int x = s - v;
                if (x < min) {
                    continue;
                }
                if (x > max) {
                    break;
                }
                res += map[x - min];
            }
            map[v - min]++;
        }
        return (int) (res % 1_000_000_007L);
    }

    /**
     * 本人首次AC解法
     * 思路如下：
     * 直接遍历时间复杂度为 n 的平方, 会超时
     * 可以转换一下思路：遍历所有出现的数, 先计算每个数出现的次数, 然后遍历所有2的次幂数
     * 找出另一半的值是否存在, 如果存在计算该值即可, 这样时间复杂度会大大降低
     *
     * @param deliciousness
     * @return
     */
    public int countPairs2(int[] deliciousness) {

        long count = 0;

        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int d : deliciousness) {
            map.put(d, map.getOrDefault(d, 0) + 1);
            max = Math.max(d, max);
        }


        for (int d : map.keySet()) {
            int k = 1;
            int m = (int)Math.pow(2, 21);
            while (k <= m) {
                if (d > k) {
                    k <<= 1;
                    continue;
                }

                if (d + max < k){
                    break;
                }

                if (2 * d == k) {
                    count += (long) map.get(d) * (map.get(d) - 1);
                } else {
                    count += map.get(d) * map.getOrDefault(k - d, 0);
                }
                k <<= 1;
            }
        }

        return (int) (count / 2 % 1000000007);
    }

    public static void main(String[] args) {
        Question1711 q = new Question1711();
        int[] deliciousness = {1, 1, 1, 3, 3, 3, 7};
        System.out.println(q.countPairs2(deliciousness));
    }
}
