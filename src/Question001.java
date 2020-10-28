import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 15:47 2019/10/21
 * description 数组中找到和为k的两个数的下标，假设结果唯一
 * path: https://leetcode.com/problems/two-sum/
 * level: easy
 **/

public class Question001 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        // 利用map来存储数组里的值与对应下标的关系
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 计算与该数的和为target的数字k
            // 如果k在map中存在, 直接可以在map中获取下标
            // 如果不存在, 则将该数字添加到map当中
            int k = target - nums[i];
            if (map.containsKey(k)) {
                return new int[]{i, map.get(k)};
            } else {
                map.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Question001 q = new Question001();
        int[] nums = {1, 2, 3, 4, 8};
        System.out.println(Arrays.toString(q.twoSum(nums, 7)));
    }
}

