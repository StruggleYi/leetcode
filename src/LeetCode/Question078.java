package LeetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Struggle
 * @date Created in 16:40 2019/11/12
 * description Subsets 给定一组不同的数字, 给出所有的子集的结果, 包括空集
 * note: 结果集的个数为2的n次方, 具体表现为已存在的集合取或者不取当前指向的数字即可
 * path: https://leetcode.com/problems/subsets/description/
 * level: medium
 **/
public class Question078 {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());
        for (int k : nums){
            int n = lists.size();
            int i = 0;
            //遍历已存在的集合, 不取k则表现为不改变原有的集合, 取k则表现为新建一个List将其加入到结果集当中
            while (i < n){
                List<Integer> list = lists.get(i++);
                List<Integer> temp = new ArrayList<>(list);
                temp.add(k);
                lists.add(temp);
            }
        }
        return lists;
    }

    public static void main(String[] args) {
        Question078 q = new Question078();
        int[] nums = {1,2,3};
        List<List<Integer>> lists = q.subsets(nums);
        for (List<Integer> list : lists){
            System.out.println(list.toString());
        }
    }
}
