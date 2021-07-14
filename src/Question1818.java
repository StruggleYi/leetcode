import java.util.*;

/**
 * @author Struggle
 * @date Created in 22:16 2021/7/14
 * description 绝对差值和 给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
 * 数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
 * 你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
 * 在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和
 * node:
 * path: https://leetcode-cn.com/problems/minimum-absolute-sum-difference/
 * level: medium
 **/
public class Question1818 {

    /**
     * 借鉴解法, 运行时间更快
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int[] nums1Position = new int[(int) Math.pow(10, 5) + 1];

        long currDifferSum = 0;
        int afterTransDiffer = 0;
        int beforeTransDiffer = 0;

        for (int i = 0; i < nums1.length; i++) {
            nums1Position[nums1[i]] = i + 1;
        }

        for (int i = 0; i < nums1.length; i++) {
            int differ = Math.abs(nums1[i] - nums2[i]);
            int leftNum;
            int rightNum;

            int decreaseDiffer = beforeTransDiffer - afterTransDiffer;
            if (decreaseDiffer < differ) {
                leftNum = nums2[i] - (differ - decreaseDiffer) + 1;
                rightNum = nums2[i] + (differ - decreaseDiffer) - 1;
                int newTranIndex = getMaxClose2Numi(nums1Position, leftNum, rightNum, nums2[i]);
                if (newTranIndex != -1) {
                    int newTransDiffer = Math.abs(nums1[newTranIndex] - nums2[i]);
                    currDifferSum = currDifferSum - afterTransDiffer + beforeTransDiffer + newTransDiffer;
                    beforeTransDiffer = differ;
                    afterTransDiffer = newTransDiffer;
                    continue;
                }
            }
            currDifferSum = currDifferSum + differ;
        }

        return (int) (currDifferSum % ((long) Math.pow(10, 9) + 7));
    }

    public int getMaxClose2Numi(int[] nums1Position, int leftNum, int rightNum, int mid) {
        int i = 0;
        if (leftNum < 0) {
            leftNum = 0;
        }

        while (mid + i <= rightNum && mid - i >= leftNum) {
            if (nums1Position[mid + i] != 0) {
                return nums1Position[mid + i] - 1;
            }
            if (nums1Position[mid - i] != 0) {
                return nums1Position[mid - i] - 1;
            }
            i++;
        }
        while (mid + i <= rightNum) {
            if (nums1Position[mid + i] != 0) {
                return nums1Position[mid + i] - 1;
            }
            i++;
        }
        while (mid - i >= leftNum) {
            if (nums1Position[mid - i] != 0) {
                return nums1Position[mid - i] - 1;
            }
            i++;
        }
        return -1;
    }

    /**
     * 偏暴力解法：
     * 计算出所有的绝对值差, 然后记录下来所有 nums1 中的元素, 遍历 nums2, 寻找与 nums1 中元素差值最大的
     * 最后把原来绝对值的和减去差值最大的即可
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int minAbsoluteSumDiff2(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int[] abs = new int[n];
        int[] dp = new int[100001];
        Set<Integer> set = new HashSet<>();
        Arrays.fill(dp, 100001);

        // abs记录绝对值 dp记录nums2中值与 nums1 中任意值的绝对值差最小的值
        long count = 0;
        for (int i = 0; i < n; i++) {
            abs[i] = Math.abs(nums1[i] - nums2[i]);
            dp[nums2[i]] = Math.min(dp[nums2[i]], abs[i]);
            count += abs[i];
            set.add(nums1[i]);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // count 使用二分法寻找 nums1 中与指定值 k 绝对值差最小的值
        for (int i = 0; i < n; i++) {
            dp[nums2[i]] = Math.min(dp[nums2[i]], count(list, nums2[i]));
        }

        int k = 0;
        // 最后遍历一遍, 找出变化最大的值
        for (int i = 0; i < n; i++) {
            k = Math.max(k, abs[i] - dp[nums2[i]]);
        }

        return (int) ((count - k) % 1000000007);
    }

    private int count(List<Integer> list, int k) {
        int min = 0;
        int max = list.size() - 1;

        int index = 0;
        while (min <= max) {
            int mid = (min + max) / 2;
            int i = list.get(mid);
            if (i == k) {
                return 0;
            } else if (i < k) {
                min = mid + 1;
                index = mid;
            } else {
                max = mid - 1;
            }
        }

        // 没有与之相等的值, 则需要与左或者右临界值进行判断
        int res = Math.abs(k - list.get(index));
        if (index < list.size() - 1) {
            res = Math.min(res, Math.abs(list.get(index + 1) - k));
        }

        return res;
    }

}
