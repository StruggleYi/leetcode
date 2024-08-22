package LeetCode;


/**
 * @author Struggle
 * @date Created in 2024/8/22 23:10
 * description 数组最后一个元素的最小值
 * node: 位运算 数组最小的数为 x 数组严格单增 则需要往 x 的 二进制数 的 0 位补充1 逐步递增即可找到最后一个元素
 * path: https://leetcode.cn/problems/minimum-array-end/?envType=daily-question&envId=2024-08-22
 * level: medium
 **/
public class Question3133 {

    public long minEnd(int n, int x) {
        n--; // 先把 n 减一，这样下面讨论的 n 就是原来的 n-1
        long ans = x;
        int i = 0, j = 0;
        while ((n >> j) > 0) {
            // x 的第 i 个比特值是 0，即「空位」
            if ((ans >> i & 1) == 0) {
                // 空位填入 n 的第 j 个比特值
                ans |= (long) (n >> j & 1) << i;
                j++;
            }
            i++;
        }
        return ans;
    }
}
