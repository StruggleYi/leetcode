package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 22:29 2021/6/21
 * description 二进制手表  二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间
 * node:
 * path: https://leetcode-cn.com/problems/binary-watch/
 * level: easy
 **/
public class Question401 {

    public List<String> readBinaryWatch(int turnedOn) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < 1024; ++i) {

            // 用位运算取出高 4 位和低 6 位
            int h = i >> 6, m = i & 63;
            if (h < 12 && m < 60 && Integer.bitCount(i) == turnedOn) {
                ans.add(h + ":" + (m < 10 ? "0" : "") + m);
            }
        }
        return ans;
    }
}
