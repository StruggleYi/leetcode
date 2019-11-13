import java.util.Arrays;

/**
 * @author Struggle
 * @date Created in 10:44 2019/11/11
 * description Sort Colors 给定一个数组, 其中包含3个数字, 0代表红色, 1代表白色, 2代表蓝色, 将他们进行排序, 只遍历一次
 * note: 由于只能遍历一遍, 所以我们要记录0,1,2的位置
 *       i记录当前遍历的位置, j记录2出现的次数, k记录0出现的次数, 如果遇到2则将其放到后面, 如果遇到0则将其放到前面, 最终可以得到排序的结果
 * path: https://leetcode.com/problems/sort-colors/description/
 * level: medium
 **/
public class Question075 {
    public void sortColors(int[] nums) {
        int i = 0;
        int j = 0;
        int k = 0;
        int n = nums.length;
        while (i < n - j){
            // 遇到2则将其放到末尾, j记录2出现的个数
            if (nums[i] == 2){
                nums[i] = nums[n - j - 1];
                nums[n - j - 1] = 2;
                j++;
            }
            // 遇到1则直接略过
            else if (nums[i] == 1){
                i++;
            }
            // 遇到0,判断当前0前面是否都是0, 如果不是, 则将该0与最前面的1互换位置即可
            else {
                if (k == i){
                    i ++;
                    k ++;
                }else {
                    nums[k++] = 0;
                    nums[i++] = 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Question075 q = new Question075();
        int[] nums = {2,0,2,1,1,0};
        q.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
