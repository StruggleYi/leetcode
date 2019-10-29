import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 11:15 2019/10/28
 * description Next Permutation  数组的下一个排列(按照升序)
 * 思路： 从最后一位向前, 寻找到第一个比最后数字小的位置
 *       eg:  1 3 2
 *       从2开始, 3要大与2, 继续往前寻找,发现1符合要求,即把2放置该位置, 后面的数字进行重排即可
 *       若整个数列不包含此情况,则说明此序列为倒序排列, 翻转此序列即可
 **/
public class Question031 {
    public void nextPermutation(int[] nums){

    }

    public static void main(String[] args) {
        Question031 q = new Question031();
        int[] nums = {3,2,1};
        q.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
