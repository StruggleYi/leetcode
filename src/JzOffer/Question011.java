package JzOffer;

/**
 * @author Struggle
 * @date Created in 21:50 2021/5/6
 * description 旋转数组的最小数字
 * node:
 * path: https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * level: easy
 **/
public class Question011 {
    public int minArray(int[] numbers) {
        int low = 0;
        int high = numbers.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] < numbers[high]) {
                high = mid;
            } else if (numbers[mid] > numbers[high]) {
                low = mid + 1;
            } else {
                high -= 1;
            }
        }
        return numbers[low];
    }

    public static void main(String[] args) {
        Question011 q = new Question011();
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(q.minArray(nums));
    }
}
