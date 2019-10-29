/**
 * @author Struggle
 * @date Created in 17:50 2019/10/29
 * description  Search in Rotated Sorted Array  给定一个递增数组, 该数组被右移了n位, 为一个变形的递增数组
 *                                              寻找指定数字k的下标, 时间复杂度o(log n)
 **/
public class Question033 {
    public int search(int[] nums, int target) {
        if (nums.length == 1){
            if (target == nums[0]){
                return 0;
            }else {
                return -1;
            }
        }

        int a = nums[0], b = nums[nums.length - 1];

        return 0;
    }

    public static void main(String[] args) {
        Question033 q = new Question033();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(q.search(nums, 0));
    }
}
