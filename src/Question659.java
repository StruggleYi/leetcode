import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 20:38 2021/1/13
 * description
 * node:
 * path:
 * level:
 **/
public class Question659 {

    /**
     * 本人参照题解的贪心算法求解
     * 本题贪心的思路不在于计算出最长的连续子串，这样会导致剩下的点无法满足要求
     * 例如： 1 2 3 3 4 5, 如果贪心求得最长连续子串, 则会出现选取 1 2 3 4 5, 最后剩余 3 无法满足要求的情况出现
     *      实际上如果拆分成 1 2 3, 3 4 5 即可满足要求
     * 本题贪心的思路在于，在判断一个值K时, 首先判断当前有没有以k-1结尾的满足条件的子串, 如果有则将其加到末尾
     * 如果没有, 则需要以k为头, 寻找出满足条件的子串, 否则不满足要求
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        if (nums == null || nums.length <= 2) {
            return false;
        }

        // set用来存储已有的以k结尾的满足要求的子串
        List<Integer> set = new ArrayList<>();

        List<Integer> list = new LinkedList<>();
        for (int k : nums) {
            list.add(k);
        }

        int[] flag = new int[nums.length];

        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int target = num - 1;

            // 表示该数字已被读过
            if (flag[i] == 1) {
                continue;
            }

            // 读取到第i个数字时，判断有没有到i-1的满足条件的子序列，如果有则直接加入到子序列中
            if (set.contains(target)) {
                set.remove(Integer.valueOf(target));
                set.add(num);
            } else {
                int len = 1;
                // 如果没有找到，则需要寻找到一个满足条件的子序列
                for (int j = i + 1; j < list.size() && len < 3; j++) {
                    if (list.get(j) == num + 1 && flag[j] == 0) {
                        len++;
                        num++;
                        flag[j] = 1;
                    } else if (list.get(j) > num + 1) {
                        return false;
                    }
                }

                if (len == 3) {
                    set.add(num);
                } else {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * leetcode 优化解法
     * 在遍历的过程中实际上只需要记住，在读取到该数字时，前面长度为1和2的子序列有多少个
     * 如果当前的数不与之前的数连续，且长度为1和2的子序列个数均不为0，则说明有长度不为3的子序列出现
     * 如果当前的数与之前的数连续，但是重复的个数小于长度为1和2的子序列个数之和，那么说明还是有一部分子序列无法得到连续的数凑成长度为3的子序列
     * 优先补足长度为1的子序列，然后补足长度为2的子序列，最后补到长度为3的子序列中，如果还有剩余，则为长度为1的子序列
     *
     * @param nums
     * @return
     */
    public boolean isPossible2(int[] nums) {
        int prevNum = 0;

        // 分别代表当前数之前的长度为1、2、3的子序列个数
        int prevEnd1 = 0, prevEnd2 = 0, prevEnd3 = 0;
        // 当前长度为1、2、3的子序列个数（用于循环中计算）
        int curEnd1 = 0, curEnd2 = 0, curEnd3 = 0;

        for (int i = 0; i < nums.length;) {
            int curNum = nums[i];
            int cnt = 0;

            // 计算当前数重复出现的次数
            while (i < nums.length && nums[i] == curNum) {
                cnt++;
                i++;
            }

            // 前一个数与当前数不连续的情况
            if (prevNum + 1 != curNum) {
                // 长度为1和2的子序列存在
                if (prevEnd1 != 0 || prevEnd2 != 0) {
                    return false;
                }
                curEnd1 = cnt;
                curEnd2 = 0;
                curEnd3 = 0;
            } else {
                // 如果长度为1、2的自序列个数大于当前数字重复出现的次数，则不满足要求
                if (prevEnd1 + prevEnd2 > cnt) {
                    return false;
                }
                // 首先加到长度为1的子序列中，变成长度为2的子序列
                curEnd2 = prevEnd1;
                // 然后加到长度为2的子序列中，变成长度为3的子序列
                curEnd3 = prevEnd2;

                // 剩余重复的个数
                int remain = cnt - prevEnd1 - prevEnd2;

                // 剩余的优先加到满足要求的子串中，最后多余的组成长度为1的子串
                int numOfOldLongChain = Math.min(prevEnd3, remain);
                curEnd3 += numOfOldLongChain;

                curEnd1 = Math.max(0, remain - numOfOldLongChain);
            }

            prevNum = curNum;
            prevEnd1 = curEnd1;
            prevEnd2 = curEnd2;
            prevEnd3 = curEnd3;
        }

        return curEnd1 == 0 && curEnd2 == 0;
    }

    public static void main(String[] args) {
        Question659 q = new Question659();

        int[] nums = {1, 2, 3, 4, 4, 5};
        System.out.println(q.isPossible(nums));
    }
}
