import java.util.*;

/**
 * @author Struggle
 * @date Created in 9:05 2019/11/4
 * description Intersection of Two Arrays 求两个数组的交集
 * path: https://leetcode.com/problems/intersection-of-two-arrays/description/
 * level: easy
 **/
public class Question349 {
    /**
     *  常规方法, 将数组先排序, 使用双指针寻找共同出现的数字
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                nums1[k] = nums1[i];
                while (i < nums1.length && nums1[i] == nums1[k]) {
                    i++;
                }
                while (j < nums2.length && nums2[j] == nums1[k]) {
                    j++;
                }
                k++;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     *  方法二： 使用一个数组记录出现数字的位置, 遍历第二个数组直接判断此数字有没有出现过
     */
    public int[] intersection2(int[] nums1, int[] nums2){
        boolean[] flag = new boolean[10000];
        for (int k : nums1){
            flag[k] = true;
        }

        int[] nums = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        int i = 0;
        for (int k : nums2){
            if (flag[k]){
                nums[i++] = k;
                flag[k] = false;
            }
        }
        return Arrays.copyOfRange(nums, 0, i);
    }

    public static void main(String[] args) {
        Question349 q = new Question349();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(Arrays.toString(q.intersection2(nums1, nums2)));
    }
}
