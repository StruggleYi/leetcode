package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 23:08 2021/7/29
 * description 二叉树寻路  一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记
 * 给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的
 * node:
 * path: https://leetcode-cn.com/problems/path-in-zigzag-labelled-binary-tree/
 * level: medium
 **/
public class Question1104 {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> res = new ArrayList<>();
        res.add(label);

        while (label > 1) {
            label = findFatherNode(label);
            res.add(label);
        }

        Collections.reverse(res);

        return res;
    }

    private int findFatherNode(int label) {
        int k = (int) (Math.log(label) / Math.log(2)) + 1;

        int n = label;
        if (k % 2 == 0) {
            n = (int) Math.pow(2, k) + (int) Math.pow(2, k - 1) - n - 1;
            return n / 2;
        }

        n /= 2;
        return (int) Math.pow(2, k - 1) + (int) Math.pow(2, k - 2) - n - 1;
    }
}
