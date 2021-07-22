package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 10:33 2019/10/31
 * description  Permutations  给定一组不相同的数字, 给出所有可能的排列结果(全排列)
 * 思路： 采用递归的方式, 前面的数字保持不动, 递归变换后面的数字
 *
 * path: https://leetcode.com/problems/permutations/description/
 * level: medium
 **/
public class Question046 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int k : nums) {
            list.add(k);
        }
        lists.add(new ArrayList<>(list));
        fun(list, 0);
        return lists;
    }

    public void fun(List<Integer> list, int begin) {
        for (int i = begin; i < list.size(); i++) {
            if (i != begin){
                swap(list, i, begin);
                lists.add(new ArrayList<>(list));
            }
            fun(list, begin + 1);
            swap(list, i, begin);
        }
    }

    public void swap(List<Integer> list, int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        Question046 q = new Question046();
        int[] nums = {1, 2, 3};
        List<List<Integer>> lists = q.permute(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
