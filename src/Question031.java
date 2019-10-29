import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 11:15 2019/10/28
 * description Next Permutation  数组的下一个排列(按照升序)
 * 思路： 从最后一位向前, 寻找到第一个递减的数, 从该数后面的数中选择最小的大于它的数字, 将其位置互换, 再讲后面的数字进行重排列
 * eg:  1 3 2
 * 从2开始, 3要大与2, 继续往前寻找,发现1为递减, 则从1后面选出最小比它大的数字, 为2, 将两者互换2 3 1, 最后将2后面的进行重排列
 * 得到结果 2 1 3
 * 若整个数列不包含此情况,则说明此序列为倒序排列, 翻转此序列即可
 **/
public class Question031 {
    public void nextPermutation(int[] nums) {
        if (nums.length <= 1) {
            return;
        }

        //寻找第一个递减的数字
        int i = nums.length - 1;
        while (i >= 1 && nums[i - 1] >= nums[i]) {
            i--;
        }
        //若不存在则为一个非递增数列, 直接翻转即可
        if (i == 0) {
            Arrays.sort(nums);
            return;
        }

        //找出后面最小的大于它的数字
        int j = i + 1;
        int k = i;
        while (j < nums.length) {
            if (nums[j] < nums[k] && nums[j] > nums[i - 1]) {
                k = j;
            }
            j++;
        }

        int temp = nums[k];
        nums[k] = nums[i - 1];
        nums[i - 1] = temp;

        //后面的数进行重排列
        Arrays.sort(nums, i, nums.length);
    }

    public static void main(String[] args) {
        Question031 q = new Question031();
        //int[] nums = {4, 2, 0, 2, 3, 2, 0};
        int[] nums = {1, 3, 2};
        q.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
