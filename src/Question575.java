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
    public int distributeCandies(int[] candies) {
        int n = candies.length;
        Set<Integer> set = new HashSet<>();
        for (int k : candies) {
            if (set.size() >= n / 2){
                return n / 2;
            }
            set.add(k);
        }
        return set.size();
    }


    public static void main(String[] args) {
        Question575 q = new Question575();
        int[] nums = {1, 1, 2, 3};
        System.out.println(q.distributeCandies(nums));
    }
}
