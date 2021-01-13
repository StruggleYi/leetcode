/**
 * @author Struggle
 * @date Created in 20:35 2021/1/13
 * description Escape The Ghosts 逃离幽灵的挣脱先达到指定位置
 * node: 不需要考虑幽灵半路拦截的情况，只需要判断有没有幽灵能够先到达指定位置即可
 * path: https://leetcode.com/problems/escape-the-ghosts/
 * level: medium
 **/
public class Question789 {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        // 计算离终点的距离
        int k = Math.abs(target[0]) + Math.abs(target[1]);
        for (int[] num : ghosts) {
            // 计算每个幽灵到目标点的距离, 如果小于k, 则一定会被拦住
            if (Math.abs(target[0] - num[0]) + Math.abs(target[1] - num[1]) <= k) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question789 q = new Question789();
        int[][] ghosts = {{5, 0}, {-10, -2}, {0, -5}, {-2, -2}, {-7, 1}};
        int[] target = {7, 7};
        System.out.println(q.escapeGhosts(ghosts, target));
    }
}
