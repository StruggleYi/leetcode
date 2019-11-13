import java.util.*;

/**
 * @author Struggle
 * @date Created in 10:41 2019/11/13
 * description Sliding Window Maximum 给定一个数组, 现有大小为k的滑动窗口, 窗口从左到右每次移动一格, 求每次滑动窗口中的最大的数字, 时间复杂度o(n)
 * path: https://leetcode.com/problems/sliding-window-maximum/description/
 * level: hard
 **/
public class Question239 {

    /**
     * 暴力解法, 时间复杂度不满足要求
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        int[] res = new int[nums.length - k + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(nums[i]);
        }
        Collections.sort(list);
        int j = 0;
        res[j++] = list.get(k - 1);
        for (int i = k; i < nums.length; i++) {
            list.remove(Integer.valueOf(nums[i - k]));
            list.add(nums[i]);
            Collections.sort(list);
            res[j++] = list.get(k - 1);
        }
        return res;
    }

    /**
     * 使用双端队列的思想
     * 在添加新元素中, 有如下情况：
     * 1、 添加的元素比队尾的元素小或相等, 直接加到队尾
     * 2、 添加的元素大于队头, 将整个队列的元素清空(原因如下：在接下来移动过程中, 最大值都会为当前元素的值, 而前面小于该元素的值都不会出现, 所以在此可以直接清除)
     * 3、 添加的元素处于队列中间, 将小于该元素的值清空, 然后加到队尾
     * 4、 添加的元素等于队头, 直接加到队头
     * (只需要往前遍历, 判断当前的数字是否比队尾大, 找到第一个不大于队尾的数字, 不存在则添加为第一个)
     * 删除元素只需要进行一个判断：
     * 如果删除的元素是队列头, 则将队列头移除, 否则不做操作
     */
    public int[] maxSlidingWindow2(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return nums;
        }
        int[] res = new int[nums.length - k + 1];
        int count = 0;
        //使用List 代替队列操作即可
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            //判断队列头会不会被移除
            if (count >= k && list.get(0) == nums[i - k]) {
                list.remove(0);
            }

            // 把队列尾小于当前指向的数给删除
            while (list.size() > 0 && list.get(list.size() - 1) < nums[i]) {
                list.remove(list.size() - 1);
            }
            list.add(nums[i]);

            //将当前最大值保存下来, 队头为最大值
            if (i >= k - 1) {
                res[i - k + 1] = list.get(0);
            }
            count++;
        }
        return res;
    }

    /**
     * 借鉴最快解法
     * 首先记录k个数中的最大值以及位置, 从k+1个数开始, 如果最大数还在范围内, 则移动窗口, 如果不在范围内, 则计算现有k个数当中最大值的位置
     */
    public int[] maxSlidingWindow3(int[] nums, int k) {
        int i = 0;
        int[] res = new int[nums.length - k + 1];
        if (nums.length == 0) {
            return nums;
        }
        int max_ind = 0;
        int max = Integer.MIN_VALUE;
        //找到前k个数中的最大值以及下标
        while (i < k) {
            if (nums[i] > max) {
                max_ind = i;
                max = nums[i];
            }
            i++;
        }
        res[0] = max;
        int j = 1;
        while (i < nums.length) {
            //如果数字更大, 则更新最大值的位置
            if (nums[i] > max) {
                max = nums[i];
                max_ind = i;
            }
            //如果最大值已不在改窗口内, 则遍历现有窗口的数, 更新最大值以及其下标
            else if (max_ind <= i - k) {
                int end = i;
                max = Integer.MIN_VALUE;
                while (end > i - k) {
                    if (nums[end] > max) {
                        max = nums[end];
                        max_ind = end;
                    }
                    end--;
                }
            }
            res[j++] = max;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Question239 q = new Question239();
        int[] nums = {9, 10, 9, -7, -4, -8, 2, -6};
        System.out.println(Arrays.toString(q.maxSlidingWindow2(nums, 5)));
    }
}
