package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 23:34 2021/7/25
 * description 从相邻元素对还原数组
 * node:
 * path: https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/
 * level: medium
 **/
public class Question1743 {

    static int N = (int) 1e6 + 10;
    static int[] q = new int[N];

    /**
     * 双向指针参考解法
     * 地址：https://leetcode-cn.com/problems/restore-the-array-from-adjacent-pairs/solution/gong-shui-san-xie-yi-ti-shuang-jie-dan-x-elpx/
     *
     * @param aps
     * @return
     */
    public int[] restoreArray(int[][] aps) {
        int m = aps.length, n = m + 1;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] ap : aps) {
            int a = ap[0], b = ap[1];
            List<Integer> alist = map.getOrDefault(a, new ArrayList<>());
            alist.add(b);
            map.put(a, alist);
            List<Integer> blist = map.getOrDefault(b, new ArrayList<>());
            blist.add(a);
            map.put(b, blist);
        }
        int l = N / 2, r = l + 1;
        int std = aps[0][0];
        List<Integer> list = map.get(std);
        q[l--] = std;
        q[r++] = list.get(0);
        if (list.size() > 1) {
            q[l--] = list.get(1);
        }
        while ((r - 1) - (l + 1) + 1 < n) {
            List<Integer> alist = map.get(q[l + 1]);
            int j = l;
            for (int i : alist) {
                if (i != q[l + 2]) {
                    q[j--] = i;
                }
            }
            l = j;

            List<Integer> blist = map.get(q[r - 1]);
            j = r;
            for (int i : blist) {
                if (i != q[r - 2]) {
                    q[j++] = i;
                }
            }
            r = j;
        }
        int[] ans = new int[n];
        for (int i = l + 1, idx = 0; idx < n; i++, idx++) {
            ans[idx] = q[i];
        }
        return ans;
    }


    /**
     * 暴力破解，找到边的值, 然后依次寻找周围值
     *
     * @param adjacentPairs
     * @return
     */
    public int[] restoreArray2(int[][] adjacentPairs) {
        if (adjacentPairs.length == 1) {
            return adjacentPairs[0];
        }

        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for (int[] adjacentPair : adjacentPairs) {
            if (set.contains(adjacentPair[0])) {
                set.remove(adjacentPair[0]);
            } else {
                set.add(adjacentPair[0]);
            }

            if (set.contains(adjacentPair[1])) {
                set.remove(adjacentPair[1]);
            } else {
                set.add(adjacentPair[1]);
            }

            List<Integer> list1 = map.getOrDefault(adjacentPair[0], new ArrayList<>());
            list1.add(adjacentPair[1]);
            map.put(adjacentPair[0], list1);

            List<Integer> list2 = map.getOrDefault(adjacentPair[1], new ArrayList<>());
            list2.add(adjacentPair[0]);
            map.put(adjacentPair[1], list2);
        }

        int len = adjacentPairs.length + 1;
        int[] res = new int[len];

        for (Integer k : set) {
            res[0] = k;
            break;
        }

        set = new HashSet<>();
        set.add(res[0]);
        for (int i = 1; i < len; i++) {
            List<Integer> list = map.get(res[i - 1]);
            int k = list.get(0);
            if (set.contains(k)) {
                k = list.get(1);
            }
            set.add(k);

            res[i] = k;
        }

        return res;
    }

    public static void main(String[] args) {
        Question1743 q = new Question1743();
        int[][] adjacentPairs = {{2, 1}, {3, 4}, {3, 2}};
        System.out.println(Arrays.toString(q.restoreArray(adjacentPairs)));
    }
}
