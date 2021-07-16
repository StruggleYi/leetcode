package JzOffer;

/**
 * @author Struggle
 * @date Created in 20:06 2021/7/16
 * description 在排序数组中查找数字 I  统计一个数字在排序数组中出现的次数
 * node:
 * path: https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof/
 * level: easy
 **/
public class Question053_1 {

    /**
     * 暴力遍历
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int k = 0;

        for (int num : nums) {
            if (num == target) {
                k++;
            } else if (num > target) {
                break;
            }
        }

        return k;
    }

    /**
     * 二分求出边界
     *
     * @param nums
     * @param t
     * @return
     */
    public int search2(int[] nums, int t) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int a = -1, b = -1;

        // 二分出左边界
        int l = 0, r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] >= t) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (nums[r] != t) {
            return 0;
        }
        a = r;

        // 二分出右边界
        l = 0;
        r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] <= t) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        if (nums[r] != t) {
            return 0;
        }
        b = r;

        return b - a + 1;
    }

    public static void main(String[] args) {
        Question053_1 q = new Question053_1();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(q.search(nums, 8));
    }
}
