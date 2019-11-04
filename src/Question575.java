import java.util.*;

/**
 * @author Struggle
 * @date Created in 11:19 2019/11/4
 * description Distribute Candies 给定一个数组, 数组中的相同的数字代表一类人, 将这些人分为人数相等的两部分, 使得其中一部分人中的类别更多, 返回最多的类别数目
 * note: 由于没有要求相同类别的人要加入同一边, 所以只需要判断有多少类别的人以及人的总数即可, 如果类别数大于等于一半的人数, 则返回一半的人数即可, 表示可以从不同的类别当中选取一个人, 否则返回类别数
 * path: https://leetcode.com/problems/distribute-candies/submissions/
 * level: easy
 **/
public class Question575 {
    /**
     * 方法一： 使用set来统计种类
     */
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        Set<Integer> set = new HashSet<>();
        for (int k : candies) {
            if (set.size() >= n / 2) {
                return n / 2;
            }
            set.add(k);
        }
        return set.size();
    }

    /**
     * 方法二： 由于已知数组的数字的范围, 可以利用数组访问的速度更快的特性, 使用数组替换set, 运行时间更快
     * note: 数组中数字的范围为[-100,000, 100,000], 采用偏移值计算即可
     * tips: 可以先不统计哪些数字出现过, 可以直接判断哪些数字没有出现过, 可以减少一次遍历的时间
     */
    public int distributeCandies2(int[] candies) {
        if (candies == null || candies.length == 0) {
            return 0;
        }

        boolean[] flag = new boolean[200001];
        int offset = 100000;
        int count = 0;
        // 如果种类已经占据一半的话, 直接返回即可
        for (int i = 0; i < candies.length && count < candies.length >> 1; i++) {
            //该数字没出现的话, count加1
            if (!flag[candies[i] + offset]) {
                flag[candies[i] + offset] = true;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Question575 q = new Question575();
        int[] nums = {1, 1, 2, 3};
        System.out.println(q.distributeCandies2(nums));
    }
}
