/**
 * @author Struggle
 * @date Created in 9:31 2019/10/22
 * description 寻找两个有序数组的中位数, 时间复杂度o(log(m+n))
 **/
public class Question004 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (n < m) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int temp1 = m;
            m = n;
            n = temp1;
        }

        int low = 0, high = m;
        int i, j;  //i 代表nums1 左边数字的个数, j 代表nums2 左边数字的个数
        while (low <= high) {
            i = (low + high) / 2;
            j = (m + n + 1) / 2 - i;

            if (i < high && nums2[j - 1] > nums1[i]) {
                low = i + 1;
            } else if (i > low && nums2[j] < nums1[i - 1]) {
                high = i - 1;
            } else {
                int maxLeft;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }

                //左边的个数多于 右边  如果为奇数个,则中位数在左边
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }

                int minRight;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(nums2[j], nums1[i]);
                }

                return (maxLeft + minRight) / 2.0;
            }

        }

        return 0.0;
    }

    public static void main(String[] args) {
        Question004 q = new Question004();

        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(q.findMedianSortedArrays(nums1, nums2));
    }
}
