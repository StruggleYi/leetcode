package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Struggle
 * @date Created in 21:59 2021/4/29
 * description 青蛙过河 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）
 *                             如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位
 * node: 可以使用暴力法解决, 但是会超时, 需要将重复计算的部分去除掉
 * path: https://leetcode-cn.com/problems/frog-jump/
 * level: hard
 **/
public class Question403 {

    /**
     * 本人做法
     * 因为里面有很多中间状态是重复计算的, 需要将其记录下来, 避免频繁的重复递归计算
     *
     * @param stones
     * @return
     */
    public boolean canCross(int[] stones) {
        // 第一个点只能跳1个单位, 所以stones[1]只能为1
        if (stones[1] - stones[0] > 1) {
            return false;
        }

        // map 用来记录第 i 个点时, 跳跃 k 个单位失败的点, set 记录当跳跃到 i 时, 有哪些不能达到终点的k的值
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // 由于第一个点已经固定只能跳1, 所以递归计算时, 可以从第二个点开始计算
        return jump(stones, 1, 1, map);
    }

    private boolean jump(int[] stones, int i, int k, Map<Integer, Set<Integer>> map) {
        // 如果到了终点返回 true
        if (i == stones.length - 1) {
            return true;
        }

        // 遍历下一个能跳到的点
        int j = i + 1;
        while (j < stones.length) {

            // 如果跳不到下一个点, 说明不能到达终点
            if (stones[j] - stones[i] > k + 1) {
                return false;
            } else if (stones[j] - stones[i] < k - 1) {
                // 如果下一个点距离过近, 寻找下一个点
                j++;
            } else {
                Set<Integer> set;
                if (map.containsKey(j)) {
                    set = map.get(j);
                } else {
                    set = new HashSet<>();
                }
                // 如果之前计算过当前点跳跃 k 个单位的值, 直接跳过, 避免重复递归
                // 否则以此点为起点, 进行递归计算
                if (!set.contains(stones[j] - stones[i]) && jump(stones, j, stones[j] - stones[i], map)) {
                    return true;
                } else {
                    // 说明这个点不行, 将 k 放到 set 中记录下来
                    set.add(stones[j] - stones[i]);
                    map.put(j, set);
                    j++;
                }
            }
        }

        // 到最后都没走到终点, 则返回false
        return false;
    }

    /**
     * 递归解法, 使用一个变量记录是否达到终点, 在每一个点 分别递归 k + 1, k, k - 1 的情况
     * 找到能够达到终点的路径之后, 所有递归都停止计算, 直接return
     * 但是这种方法会超时
     */
    boolean found;

    public boolean canCross2(int[] stones) {
        for (int i = 3; i < stones.length; i++) {
            if (stones[i] > 2 * stones[i - 1] + 1) {
                return false;
            }
        }
        check(stones, 0, 1);
        return found;
    }

    private void check(int[] stones, int index, int step) {
        // k 减到0或者已经找到一个方案能跳到终点时, 直接返回
        if (step == 0 || found) {
            return;
        }

        // 走到了终点, found 置为 true
        if (index == stones.length - 1) {
            found = true;
            return;
        }

        // reach为需要寻找的值, 遍历找该值, 如果找到了, 以此点为起点, 递归 k + 1, k, k - 1 的情况
        int reach = stones[index] + step;
        for (int i = index + 1; i < stones.length; i++) {
            if (reach > stones[i]) {
                continue;
            }

            if (reach < stones[i]) {
                break;
            }

            check(stones, i, step + 1);
            check(stones, i, step);
            check(stones, i, step - 1);
        }
    }

    public static void main(String[] args) {
        Question403 q = new Question403();
        int[] stones = {0, 1, 2, 5, 6, 9, 10, 12, 13, 14, 17, 19, 20, 21, 26, 27, 28, 29, 30};
        System.out.println(q.canCross(stones));
    }
}
