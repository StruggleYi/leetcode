import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @author Struggle
 * @date Created in 2020/11/17 11:01
 * description Sum of Subarray Minimums 求子数组中最小值的和
 * node:
 * path: https://leetcode.com/problems/sum-of-subarray-minimums/
 * level: medium
 **/
public class Question907 {
    /**
     * leetcode 借鉴解法，使用栈来存储
     */
    public int sumSubarrayMins(int[] A) {
        final int mod = 1000000007;
        int n = A.length;
        // Every element cur in stack,
        // cur[0] is the value,
        // and cur[1] is how many times cur[0] can be counted
        Stack<int[]> stack = new Stack<>();
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            int len = 1;
            while (!stack.isEmpty() && stack.peek()[0] > A[i]) {
                int[] cur = stack.pop();
                len += cur[1];
            }
            stack.push(new int[]{A[i], len});
            left[i] = len;
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            int len = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= A[i]) {
                int[] cur = stack.pop();
                len += cur[1];
            }
            stack.push(new int[]{A[i], len});
            right[i] = len;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (int) ((ans + (long) A[i] * left[i] * right[i]) % mod);
        }
        return ans;
    }

    /**
     * 二分查找，使用list会造成内存超限, 这里的思路没有问题，主要是实现的方式不合理
     *
     */
    public int sumSubarrayMins2(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        List<Integer> list = new ArrayList<>();
        for (int k : arr) {
            list.add(k);
        }
        return countSum2(list);
    }

    private int countSum2(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return 0;
        }
        int min = Collections.min(list);
        int minIndex = list.indexOf(min);
        int sum = min * (minIndex + 1) * (list.size() - minIndex);
        if (minIndex > 0) {
            sum = (sum + countSum2(new ArrayList<>(list.subList(0, minIndex)))) % 1000000007;
        }
        if (minIndex < list.size() - 1) {
            sum = (sum + countSum2(new ArrayList<>(list.subList(minIndex + 1, list.size())))) % 1000000007;
        }
        return sum;
    }

    /**
     * 常规做法，采用遍历的方式实现，每次记录最小值，但是会超时
     */
    public int sumSubarrayMins3(int[] arr) {
        if (arr == null || arr.length < 1) {
            return 0;
        }
        if (arr.length == 1) {
            return arr[0];
        }
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            sum = (sum + min) % 1000000007;
            for (int j = i + 1; j < arr.length; j++) {
                min = Math.min(min, arr[j]);
                sum = (sum + min) % 1000000007;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Question907 q = new Question907();
        int[] arr = {11, 81, 94, 43, 3};
        System.out.println(q.sumSubarrayMins(arr));
    }
}
