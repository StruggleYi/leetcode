/**
 * @author Struggle
 * @date Created in 21:18 2021/6/15
 * description 山脉数组的峰顶索引 从山峰数组中找出封顶的下标  时间复杂度 o(log n)
 * node: 二分法, 判断与边上节点的关系即可
 * path: https://leetcode-cn.com/problems/peak-index-in-a-mountain-array/
 * level: easy
 **/
public class Question852 {
    public int peakIndexInMountainArray(int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            // 比右边节点小, 峰顶在右边
            if (arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low;
    }
}
