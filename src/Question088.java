import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 10:23 2019/10/22
 * description 将两个有序的数组合并,数组2合并到数组1中
 **/
public class Question088 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
            } else if (i >= 0) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
    }

    public static void main(String[] args) {
        Question088 q = new Question088();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        q.merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
