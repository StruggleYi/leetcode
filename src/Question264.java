/**
 * @author Struggle
 * @date Created in 21:58 2021/4/16
 * description 丑数 就是只包含质因数 2、3 和/或 5 的正整数, 返回第 n 个丑数, 第一个丑数是 1
 * node: 丑数是由前面的丑数乘以2 3 5所得
 * path: https://leetcode.com/problems/ugly-number-ii/
 *       https://leetcode-cn.com/problems/ugly-number-ii/
 * level: medium
 **/
public class Question264 {

    public int nthUglyNumber(int n) {
        int[] nums = new int[n + 1];

        int i = 2;
        int p1 = 1, p2 = 1, p3 = 1;
        nums[1] = 1;
        while (i <= n) {
            int min = Math.min(nums[p1] * 2, Math.min(nums[p2] * 3, nums[p3] * 5));
            nums[i++] = min;
            if (nums[p1] * 2 == min) {
                p1++;
            }
            if (nums[p2] * 3 == min) {
                p2++;
            }
            if (nums[p3] * 5 == min) {
                p3++;
            }
        }
        return nums[n];
    }

}
