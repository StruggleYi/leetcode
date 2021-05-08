/**
 * @author Struggle
 * @date Created in 22:03 2021/5/8
 * description  完成所有工作的最短时间  给你一个整数数组 jobs ，其中 jobs[i] 是完成第 i 项工作要花费的时间
 * 请你将这些工作分配给 k 位工人。所有工作都应该分配给工人，且每项工作只能分配给一位工人。工人的 工作时间 是完成分配给他们的所有工作花费时间的总和
 * node:
 * path: https://leetcode-cn.com/problems/find-minimum-time-to-finish-all-jobs/
 * level: hard
 **/
public class Question1723 {

    int n;
    int ans = Integer.MAX_VALUE;

    /**
     * 暴力遍历的时间复杂度为k的n次方, 不满足要求
     * 优先分配给「空闲工人」并没有改变理论上的时间复杂度, 只是稍微改变遍历的顺序
     * 尽可能快的获取到比较小的max 值, 从而在后续遍历的过程中能够减掉更多的无用分支
     * @param jobs
     * @param k
     * @return
     */
    public int minimumTimeRequired(int[] jobs, int k) {
        n = jobs.length;
        int[] sum = new int[k];
        dfs(jobs, 0, sum, 0, k, 0);
        return ans;
    }

    /**
     *
     * @param jobs 任务
     * @param u 正分配的工作
     * @param sum 每个工人的任务和
     * @param max 工人最大的工作量
     * @param k 工人数
     * @param used 已分配工作的工人数
     */
    void dfs(int[] jobs, int u, int[] sum, int max, int k, int used) {
        if (max >= ans) {
            return;
        }
        if (u == n) {
            ans = max;
            return;
        }

        // 优先分配给「空闲工人」
        if (used < k) {
            sum[used] = jobs[u];
            dfs(jobs, u + 1, sum, Math.max(sum[used], max), k, used + 1);
            sum[used] = 0;
        }

        for (int i = 0; i < used; i++) {
            sum[i] += jobs[u];
            dfs(jobs, u + 1, sum, Math.max(sum[i], max), k, used);
            sum[i] -= jobs[u];
        }
    }


    public static void main(String[] args) {
        Question1723 q = new Question1723();
        int[] jobs = {254, 256, 256, 254, 251, 256, 254, 253, 255, 251, 251, 255};
        System.out.println(q.minimumTimeRequired(jobs, 10));
    }
}
