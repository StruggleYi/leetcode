package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 17:09 2019/10/30
 * description  Combination Sum II  给定一组数字, 求出和为k的所有数字集合, 数字只能使用一次
 **/
public class Question040 {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return lists;
        }
        Arrays.sort(candidates);
        findNum(candidates, target, 0, lists, new ArrayList<>());
        return lists;
    }

    public void findNum(int[] candidates, int target, int begin, List<List<Integer>> lists, List<Integer> list) {
        if (target == 0) {
            lists.add(new ArrayList<>(list));
            return;
        }

        for (int k = begin; k < candidates.length && candidates[k] <= target; k++) {
            if (k > begin && candidates[k] == candidates[k - 1]){
                continue;
            }
            list.add(candidates[k]);
            findNum(candidates, target - candidates[k], k + 1, lists, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question040 q = new Question040();
        int[] nums = {10,1,2,7,6,1,5};
        List<List<Integer>> lists = q.combinationSum2(nums, 8);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
