package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:17 2021/8/2
 * description 网络延迟时间 有 n 个网络节点，标记为 1 到 n。
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号
 * node:
 * path: https://leetcode-cn.com/problems/network-delay-time/
 * level: medium
 **/
public class Question743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        // 邻接矩阵：graph
        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], Integer.MAX_VALUE);
        }
        for (int[] time : times) {
            graph[time[0] - 1][time[1] - 1] = time[2];
        }
        // 访问列表：visited
        boolean[] visited = new boolean[n];
        // 距离列表：shortest
        int[] shortest = new int[n];
        Arrays.fill(shortest, Integer.MAX_VALUE);
        shortest[k - 1] = 0;
        // 迪杰斯特拉算法计算单源最短路径
        while (true) {
            int index = -1;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && min > shortest[i]) {
                    index = i;
                    min = shortest[i];
                }
            }
            if (index == -1) {
                break;
            }
            visited[index] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[index][i] != Integer.MAX_VALUE) {
                    shortest[i] = Math.min(shortest[i], min + graph[index][i]);
                }
            }
        }
        int delay = Integer.MIN_VALUE;
        // 若有节点没有被访问, 则返回 -1
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return -1;
            }
            delay = Math.max(delay, shortest[i]);
        }
        return delay;
    }
}
