package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 21:51 2021/6/13
 * description 砖墙 现有一面墙, 由若干块砖构成, 砖的长度不一, 但是最后构成墙的长度统一, 现需要你从上往下画一根直线, 使得直线穿过的砖的个数最少, 从墙两侧划线不满足要求
 * node: 要想穿过的砖越少, 则需要经过的缝隙越多, 统计缝隙最多的数即可
 * path: https://leetcode-cn.com/problems/brick-wall/
 * level: medium
 **/
public class Question554 {

    /**
     * LeetCode 时间花费很少的解法
     */
    public int leastBricks(List<List<Integer>> wall) {

        // prefixSum 记录每列砖缝隙的位置
        List<int[]> prefixSum = new ArrayList<>();
        int wallNum = wall.size();
        for (List<Integer> list : wall) {
            int n = list.size();
            int[] prefix = new int[n - 1];
            int sum = 0;
            for (int i = 0; i < n - 1; ++i) {
                sum += list.get(i);
                prefix[i] = sum;
            }
            prefixSum.add(prefix);
        }

        // map 统计每个缝隙出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        int max = 0;
        for (int[] arr : prefixSum) {
            for (int num1 : arr) {
                if (map.containsKey(num1)) {
                    int val = map.get(num1);
                    map.put(num1, ++val);
                } else {
                    map.put(num1, 1);
                }
            }
        }

        // 遍历每个缝隙出现的次数, 取出最大值
        for (int a : map.values()) {
            if (a > max) {
                max = a;
            }
        }

        // 总行数减去最多缝隙出现的个数, 即最少穿过转的块数
        return wallNum - max;
    }


    /**
     * 本人首次解法, 尝试从1开始进行遍历, 但是这里做了优化, 会在计算当前列经过砖的块数时, 同时判断出下一列的位置
     * 这个位置不是简单的+1, 而是所有列中, 下一列最靠左的缝隙的位置
     *
     * @param wall
     * @return
     */
    public int leastBricks2(List<List<Integer>> wall) {
        int n = wall.size();
        int len = 0;
        int min = n;

        // index 记录当前每列遍历到那一块砖, location是当前砖的右边缝隙的位置
        int[] index = new int[n];
        int[] location = new int[n];

        // 计算墙的长度
        List<Integer> brickList = wall.get(0);
        for (int k : brickList) {
            len += k;
        }

        // 计算每列当前最近缝隙的位置
        for (int i = 0; i < n; i++) {
            location[i] = wall.get(i).get(0);
        }

        // 从第一个缝隙开始遍历计算
        for (int j = 1; j < len; ) {
            int next = len;
            int count = 0;

            // 遍历每列砖
            for (int i = 0; i < n; i++) {

                // 当前列遇到缝隙, 则砖往后移一块
                if (location[i] == j) {
                    index[i]++;
                    location[i] += wall.get(i).get(index[i]);
                } else {
                    count++;
                }
                // 记录下来应该右移的位置, 直接+1的效率太慢
                next = Math.min(next, location[i]);
            }

            min = Math.min(count, min);
            j = next;
        }

        return min;
    }

    public static void main(String[] args) {
        Question554 q = new Question554();
        List<List<Integer>> wall = new ArrayList<>();
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(1, 1, 3, 1));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(3, 1, 2));
        wall.add(Arrays.asList(1, 2, 2, 1));
        wall.add(Arrays.asList(4, 2));
        wall.add(Arrays.asList(4, 1, 1));
        wall.add(Arrays.asList(1, 1, 4));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(2, 2, 2));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(1, 3, 2));
        wall.add(Arrays.asList(1, 1, 2, 1, 1));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(4, 1, 1));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(6));
        wall.add(Arrays.asList(5, 1));
        wall.add(Arrays.asList(3, 2, 1));

        System.out.println(q.leastBricks(wall));
    }
}
