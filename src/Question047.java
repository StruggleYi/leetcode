import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 11:39 2019/10/31
 * description Permutations II  全排列(所给的数字可能包含重复数字)
 *
 * path: https://leetcode.com/problems/permutations-ii/description/
 * level: medium
 **/
public class Question047 {

    /**
        此部分为暴力递归算法, 之间会包含许多重复值
     */
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int k : nums){
            list.add(k);
        }
        Collections.sort(list);
        lists.add(new ArrayList<>(list));
        fun(list, 0);
        return lists;
    }

    public void fun(List<Integer> list, int begin){
        for (int i = begin; i < list.size(); i ++){
            if (i != begin && !list.get(i).equals(list.get(i - 1))){
                swap(list, i, begin);
                if (!lists.contains(list)) {
                    lists.add(new ArrayList<>(list));
                }
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

    /** 此方法为借鉴算法, 使用一个数组来记录数字是否使用过, 同时记录上一个使用的数字是哪个
     *
     */
    public List<List<Integer>> permuteUnique2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, result, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> current, boolean[] seen) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
        } else {
            //用来记录不使用同一个数字
            //第一个添加进去的排列为从小到大的序列, pre的作用就是避免重复计算连续相等的数字
            Integer prev = null;
            for (int i = 0; i < nums.length; i++) {
                if (prev != null && nums[i] == prev) {
                    continue;
                }
                if (!seen[i]) {
                    current.add(nums[i]);
                    seen[i] = true;
                    dfs(nums, result, current, seen);
                    current.remove(current.size() - 1);
                    seen[i] = false;
                    prev = nums[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        Question047 q = new Question047();
        int[] nums = {1,1,2};
        List<List<Integer>> lists = q.permuteUnique(nums);
        System.out.println(lists.size());
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
