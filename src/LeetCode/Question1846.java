package LeetCode;

import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 23:36 2021/7/15
 * description 减小和重新排列数组后的最大元素
 * node:
 * path: https://leetcode-cn.com/problems/maximum-element-after-decreasing-and-rearranging/
 * level: medium
 **/
public class Question1846 {

    /**
     * 经过优化的思路：这里不对数组进行排序, 通过统计每个数的个数来去求得最大值, 时间复杂度更优于排序
     *
     * @param arr
     * @return
     */
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int length = arr.length;
        int[] countArr = new int[length];
        // 在计数范围内的元素个数
        int interCount = 0;

        // 计数(其实记录 1 到 length - 1 就够了，因为值为 length 的元素也是“万能牌”)
        for (int ele : arr) {
            if (ele >= 1 && ele < length) {
                countArr[ele - 1]++;
                interCount++;
            }
        }

        // 在遍历当前元素时，有多少比当前小的元素需要被补充
        int totalNeedAdd = 0;
        //计数范围内部的实际最大值
        int interMax = 0;

        //计算计数范围内部真正最大值(可优化)
        for (int i = 0; i < length; i++) {
            if (countArr[i] == 0) {
                totalNeedAdd++;
            } else {
                if (countArr[i] > totalNeedAdd) {
                    totalNeedAdd = 0;
                    interMax = i + 1;
                } else {
                    totalNeedAdd -= countArr[i];
                    interMax += countArr[i];
                }
            }
        }

        return interMax + (length - interCount);
    }

    /**
     * 常规思路： 先排序, 依次往后判断即可
     *
     * @param arr
     * @return
     */
    public int maximumElementAfterDecrementingAndRearranging2(int[] arr) {

        int len = arr.length;
        if (len <= 1) {
            return len;
        }

        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < len; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }

        return arr[len - 1];
    }

    public static void main(String[] args) {
        Question1846 q = new Question1846();
        int[] arr = {};
        System.out.println(q.maximumElementAfterDecrementingAndRearranging(arr));
    }
}
