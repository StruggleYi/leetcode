package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 21:52 2022/5/15
 * description 贴纸拼词 给定一部分单词, 每个单词可重复使用, 单词可进行拆分, 求组成给定单词所需的最小单词个数, 如果不能组成则返回 -1
 * node: 依次遍历所有的单词, 使用状态计算指定字符串中哪些单词已经被使用过, 动态规划一次进行计算即可
 * path: https://leetcode.cn/problems/stickers-to-spell-word/
 * level: hard
 **/
public class Question691 {
    int N = 20, M = 1 << 20, INF = 50;
    int[] f = new int[M];
    private String[] ss;
    String t;

    int dfs(int state) {
        int n = t.length();
        if (state == ((1 << n) - 1)) {
            return 0;
        }
        if (f[state] != -1) {
            return f[state];
        }
        int ans = INF;
        // 依次使用某张卡片, 然后继续递归计算
        for (String s : ss) {
            int nstate = state;
            out:
            // 遍历卡片的每个字符
            for (char c : s.toCharArray()) {
                // 遍历目标单词
                for (int i = 0; i < n; i++) {
                    // 查看当前字符是否与卡片对应字符相同, 并且没有被拼接过
                    if (t.charAt(i) == c && ((nstate >> i) & 1) == 0) {
                        // 当前位置置1, 表示已经使用过
                        nstate |= (1 << i);
                        continue out;
                    }
                }
            }
            // 使用这张卡片后状态发生了变化
            if (nstate != state) {
                // 取使用前后的最小值
                ans = Math.min(ans, dfs(nstate) + 1);
            }
        }
        return f[state] = ans;
    }

    public int minStickers(String[] stickers, String target) {
        ss = stickers;
        t = target;
        // f用来存储某个状态下的最小卡片个数
        Arrays.fill(f, -1);
        int ans = dfs(0);
        return ans == INF ? -1 : ans;
    }
}
