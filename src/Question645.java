import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 14:25 2021/7/4
 * description 错误的集合  集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回
 * node:
 * path: https://leetcode-cn.com/problems/set-mismatch/
 * level: easy
 **/
public class Question645 {
    public int[] findErrorNums(int[] nums) {
        int[] res = new int[2];

        int n = nums.length;
        int[] count = new int[n + 1];
        for (int k : nums) {
            count[k]++;
        }

        for (int i = 1; i <= n; i++) {
            int m = count[i];

            if (m == 0) {
                res[1] = i;
            } else if (m == 2) {
                res[0] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Question645 q = new Question645();
        int[] nums = {1, 2, 2, 4};
        System.out.println(Arrays.toString(q.findErrorNums(nums)));
    }
}
