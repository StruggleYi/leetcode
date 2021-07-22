package LeetCode;

/**
 * @author Struggle
 * @date Created in 17:50 2019/10/29
 * description  Search in Rotated Sorted Array  给定一个递增数组, 该数组被右移了n位, 为一个变形的递增数组
 * 寻找指定数字k的下标, 时间复杂度o(log n)
 **/
public class Question033 {
    public int search(int[] nums, int target) {
        if (nums.length == 1) {
            if (target == nums[0]) {
                return 0;
            } else {
                return -1;
            }
        }

        //二分 根据数字的大小判断查找的数字在哪个区域
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int a = nums[low];
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= a && nums[mid] > target && target >= a) {
                high = mid - 1;
            } else if (nums[mid] >= a ) {
                low = mid + 1;
            }else if (nums[mid] > target) {
                high = mid - 1;
            } else if (target >= a) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Question033 q = new Question033();
        int[] nums = {5,1,2};
        System.out.println(q.search(nums, 2));
    }
}
