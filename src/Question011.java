/**
 * @author Struggle
 * @date Created in 8:41 2019/10/23
 * description  Container With Most Water
 * 给定一个数组a1,a2.... 分别表示坐标(i,ai),求两个坐标中能装水的最大值
 **/
public class Question011 {
    public int maxArea(int[] height) {
        int max = 0;
        int i = 0, j = height.length - 1;
        while (i < j) {
            if (height[i] < height[j]) {
                max = Math.max(max, height[i] * (j - i));
                i++;
            } else {
                max = Math.max(max, height[j] * (j - i));
                j--;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Question011 q = new Question011();
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(q.maxArea(nums));
    }
}
