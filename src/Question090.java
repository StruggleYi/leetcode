import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 10:06 2019/11/14
 * description Subsets II 给定一组可能包含重复数字的数组, 给出所有不重复的子集集合(包含空集)
 * note: 当出现重复数字的时候, 这些数字只能加在最新出现的集合当中, 这里使用k来记录最新集合出现的位置
 * eg: [5,5,5,5,5]
 *     整个集合lists为空, 初试只有一个空集
 *     获取第一个5, 未重复出现, 则新建立一个集合, 将5加入其中, lists 中包含[], [5], 新加入的集合的位置为1
 *     获取第二个5, 重复出现, 则从位置1开始读取集合, 将[5]拿出, 加入元素5, 放入lists, lists中包含[],[5],[5,5], 新加入集合的位置为2
 *     ....
 *     可以获取到最后的结果集[],[5],[5,5],[5,5,5],[5,5,5,5],[5,5,5,5,5]
 *     记录新出现集合的位置的原因是, 如果还是从头获取lists 中的集合, 那么以前已经添加过该元素的旧集合, 在整个结果集中会重复出现
 *     比如: 在第二个5出现的时候, 还是从[]还是读取, 加入5得到新集合[5], 此集合已在lists中包含, 重复出现
 *     如果使用lists.contains(list)来判断是否重复, 会增加程序的运行时间
 * path: https://leetcode.com/problems/subsets-ii/description/
 * level: medium
 **/
public class Question090 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        int k = 0;
        for (int j = 0; j < nums.length; j++) {
            int n = lists.size();
            int i = 0;
            //数字重复出现则从新集合的位置开始遍历, 否则从头开始
            if (j - 1 >= 0 && nums[j - 1] == nums[j]) {
                i = k;
            }
            while (i < n) {
                List<Integer> list = lists.get(i++);
                List<Integer> temp = new ArrayList<>(list);
                temp.add(nums[j]);
                lists.add(temp);
            }
            k = n;
        }
        return lists;
    }

    public static void main(String[] args) {
        Question090 q = new Question090();
        int[] nums = {1, 2, 2};
        List<List<Integer>> lists = q.subsetsWithDup(nums);
        for (List<Integer> list : lists) {
            System.out.println(list.toString());
        }
    }
}
