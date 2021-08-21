package LeetCode;

import java.util.*;

/**
 * @author Struggle
 * @date Created in 23:11 2021/7/31
 * description 二叉树的垂序遍历
 * node:
 * path: https://leetcode-cn.com/problems/vertical-order-traversal-of-a-binary-tree/
 * level: hard
 **/
public class Question987 {
    Map<Integer, Map<Integer, List<Integer>>> map = new HashMap<>();
    Set<Integer> colSet = new HashSet<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Map<Integer, List<Integer>> rootCol = new HashMap<>();
        List<Integer> rootRowList = new ArrayList<>();
        rootRowList.add(root.val);
        rootCol.put(0, rootRowList);
        map.put(0, rootCol);
        colSet.add(0);
        search(root, 0, 0);

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> col = new ArrayList<>(colSet);
        Collections.sort(col);
        for (Integer i : col) {
            List<Integer> list = new ArrayList<>();

            Map<Integer, List<Integer>> listMap = map.get(i);
            List<Integer> rowList = new ArrayList<>(listMap.keySet());
            Collections.sort(rowList);
            for (Integer j : rowList) {
                List<Integer> list1 = listMap.get(j);
                if (list1.size() > 1) {
                    Collections.sort(list1);
                }

                list.addAll(list1);
            }
            res.add(list);
        }

        return res;
    }

    private void search(TreeNode root, int row, int col) {

        Map<Integer, List<Integer>> rowMap;
        if (root.left != null) {
            rowMap = map.getOrDefault(col - 1, new HashMap<>());
            List<Integer> list = rowMap.getOrDefault(row + 1, new ArrayList<>());
            list.add(root.left.val);
            rowMap.put(row + 1, list);
            map.put(col - 1, rowMap);
            colSet.add(col - 1);
            search(root.left, row + 1, col - 1);
        }

        if (root.right != null) {
            rowMap = map.getOrDefault(col + 1, new HashMap<>());
            List<Integer> list = rowMap.getOrDefault(row + 1, new ArrayList<>());
            list.add(root.right.val);
            rowMap.put(row + 1, list);
            map.put(col + 1, rowMap);
            colSet.add(col + 1);
            search(root.right, row + 1, col + 1);
        }
    }
}
