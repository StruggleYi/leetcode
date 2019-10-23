import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 11:03 2019/10/23
 * description 3Sum  找出数组中和为0的三个数
 **/
public class Question15 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int a = nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            int sum = 0 - a;
            while (j < k) {
                if (sum == nums[j] + nums[k]) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j < k && nums[j] == nums[j + 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k - 1]) {
                        k--;
                    }
                    j++;
                    k--;
                } else if (sum > nums[j] + nums[k]) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Question15 q = new Question15();
        int[] nums = {-2, 0, 0, 2, 2};
        List<List<Integer>> lists = q.threeSum(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
