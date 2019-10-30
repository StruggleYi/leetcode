/**
 * @author Struggle
 * @date Created in 9:43 2019/10/30
 * description  Trapping Rain Water  给定n个非负的整数, 表示n个柱子的高度,柱子的宽度均为1,求这些柱子在下雨天能收集多少雨水
 * 思路： 比较两边边界的值, 装的水量的高度取决于低的值, 两边往中间计算, 若碰到高的柱子则重新比较边界的值, 重新从低边界值开始计算
 *
 **/
public class Question042 {
    public int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }

        int ans = 0;
        int l = 0, r = height.length - 1;

        //首先把左右两边不能收集雨水的值给去掉
        while (l < r && height[l] <= height[l + 1]) {
            l++;
        }
        while (l < r && height[r] <= height[r - 1]) {
            r--;
        }

        //主要思路为  求出两边柱子的边界,能收集到水的最大高度为边界小的值, 于是可以先求出边界小的一边能收集到水的数量
        while (l < r) {
            int left = height[l];
            int right = height[r];
            if (left <= right) {
                // 左边界要小一些, 比左边界低的柱子能收集到的水的数量可以计算出来
                while (l < r && left >= height[++l]) {
                    ans += left - height[l];
                }
            } else {
                // 右边界要小一些, 比右边界低的柱子能收集到的水的数量可以计算出来
                while (l < r && height[--r] <= right) {
                    ans += right - height[r];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Question042 q = new Question042();
        int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(q.trap(nums));
    }
}
