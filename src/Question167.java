import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 9:43 2019/10/25
 * description  Two Sum II - Input array is sorted  寻找两个数的和为指定值, 输入数组有序且有唯一解
 **/
public class Question167 {

    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length - 1;
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                break;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return new int[]{i + 1, j + 1};
    }

    public static void main(String[] args) {
        Question167 q = new Question167();
        int[] num = {2, 7, 11, 15};
        System.out.println(Arrays.toString(q.twoSum(num, 9)));
    }
}
