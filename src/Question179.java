/**
 * @author Struggle
 * @date Created in 20:40 2021/4/12
 * description Largest Number 给定一组数字, 将其进行重新排列, 返回能够组成的最大数
 * node: 本题有个证明思路: 如果数字 x 在数字 y 前面更优, 数字 y 在数字 z 前面更优, 那么 x 满足在数字 z 前面更优的传递性
 * path: https://leetcode.com/problems/largest-number/
 * level: medium
 **/
public class Question179 {

    /**
     * leetcode 借鉴写法 手写快排
     * @param nums
     * @return
     */
    public String largestNumber(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        if (nums[0] == 0) {
            return "0";
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void quickSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = nums[start];
        // 记录每次快排后的中间位置
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            long x = 10;
            long y = 10;
            // x 代表 10的 nums[i] 的位数 次幂
            while (nums[i] >= x) {
                x *= 10;
            }
            // y 代表 10的 pivot 的位数 次幂
            while (pivot >= y) {
                y *= 10;
            }
            // 比较两个数字的排列次序谁最优, 如果nums[i]在前最优, 则调换位置
            if (nums[i] * y + pivot > nums[i] + pivot * x) {
                // 原理：index+1 是为了记录快排后start值应该放置的位置
                index += 1;
                // 这里将index 与i 互换是为了把后面第i个本应该放到前面的值挪到前面
                swap(nums, index, i);
            }
        }

        // 把首个数字放置到对应的位置
        swap(nums, index, start);
        quickSort(nums, start, index - 1);
        quickSort(nums, index + 1, end);
    }

    private void swap(int[] nums, int l, int r) {
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }


    /**
     * 暴力解法, 按照两个数字左右拼接后的大小进行排序
     * @param nums
     * @return
     */
    public String largestNumber2(int[] nums) {

        if (nums.length == 1) {
            return String.valueOf(nums[0]);
        }

        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                compare(nums, i, j);
            }
        }

        StringBuilder sb = new StringBuilder();
        // 全为0的情况, 直接返回0
        if (nums[0] == 0){
            return "0";
        }

        // 按照排好序的结果转成字符串即可
        for (int k : nums) {
            sb.append(k);
        }

        return sb.toString();
    }

    /**
     * 比较两个数字左右拼接后的大小
     * @param nums
     * @param i
     * @param j
     */
    private void compare(int[] nums, int i, int j) {
        if (nums[i] == nums[j]) {
            return;
        }

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        s1.append(nums[i]).append(nums[j]);
        s2.append(nums[j]).append(nums[i]);

        if (s1.toString().compareTo(s2.toString()) < 0) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

    }

    public static void main(String[] args) {
        Question179 q = new Question179();

        int[] nums = {0, 0, 0};
        System.out.println(q.largestNumber(nums));
    }
}
