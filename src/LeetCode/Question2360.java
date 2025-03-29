package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 2025/3/29 21:17
 * description 图中的最长环
 * node:
 * path:
 * level: hard
 **/
public class Question2360 {

    public int longestCycle(int[] edges) {
        int res = -1;
        // edge[i] 表示 i 到该点有一条有向边
        boolean[] visited = new boolean[edges.length];
        // 从每个点一次出发，判断是否能够深度遍历回到自己
        for (int i = 0; i < edges.length; i++) {
            if (visited[i]) {
                continue;
            }

            List<Integer> lists = new ArrayList<>();
            visited[i] = true;
            int next = edges[i];
            lists.add(i);
            visited[i] = true;
            while (next != -1) {
                if (visited[next]) {
                    // 已经走过了这个点
                    break;
                }

                lists.add(next);
                visited[next] = true;
                next = edges[next];
            }

            if (next != -1){
                // 走到这个点有两种情况
                // 1、出现了环，在本次循环里
                // 2、未出现环，出现在其他的循环里
                int index = lists.indexOf(next);
                if (index != -1) {
                    res = Math.max(res, lists.size() - index);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Question2360 q = new Question2360();
        System.out.println(q.longestCycle(new int[]{-1,4,-1,2,0,4}));
    }
}
