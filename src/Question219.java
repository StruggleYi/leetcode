import java.util.HashMap;
import java.util.Map;

/**
 * @author Struggle
 * @date Created in 9:50 2019/10/31
 * description  Contains Duplicate II  给定一个数组, 判断是否存在两个相隔最大距离为k的数相等
 *
 * path: https://leetcode.com/problems/contains-duplicate-ii/description/
 * level: easy
 **/
public class Question219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k){
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Question219 q = new Question219();
        int[] nums = {99, 99};
        System.out.println(q.containsNearbyDuplicate(nums, 2));
    }
}
