package LeetCode;

/**
 * @author Struggle
 * @date Created in 22:39 2021/7/23
 * description 检查是否区域内所有整数都被覆盖 给定一个区间数组, 然后给定一个范围区间, 判断该区间的所有数是否都在区间数组中存在
 * node:
 * path: https://leetcode-cn.com/problems/check-if-all-the-integers-in-a-range-are-covered/
 * level: easy
 **/
public class Question1893 {

    public boolean isCovered(int[][] ranges, int left, int right) {
        boolean[] flag = new boolean[51];
        for(int[] range : ranges){
            int l = Math.max(range[0], left);
            int r = Math.min(range[1], right);
            for(int i = l; i <= r; i++){
                flag[i] = true;
            }
        }
        for(int i = left; i <= right; i++){
            if(!flag[i]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Question1893 q = new Question1893();
        int[][] ranges = {{5, 5}};
        System.out.println(q.isCovered(ranges, 1, 5));
    }
}
