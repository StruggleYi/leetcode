import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 16:34 2019/10/30
 * description  Combination Sum  给定一个不重复数字集合, 找到所有和为k的集合, 数字可重复使用
 **/
public class Question039 {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(nums);
        backtrack(list, new LinkedList<>(), nums, target, 0);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int remain, int start) {
        if (remain == 0) {
            list.add(new LinkedList<>(tempList));
            return;
        }
        for (int i = start; i < nums.length && nums[i] <= remain; i++) {
            tempList.add(nums[i]);
            backtrack(list, tempList, nums, remain - nums[i], i);
            tempList.remove(tempList.size() - 1);
        }
    }

    public static void main(String[] args) {
        Question039 q = new Question039();
        int[] nums = {2, 3, 6, 7};
        List<List<Integer>> lists = q.combinationSum(nums, 7);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
