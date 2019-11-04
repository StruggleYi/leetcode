/**
 * @author Struggle
 * @date Created in 9:46 2019/11/4
 * description Path Sum III 给定一个二叉树, 寻找路径和为k的路径总数
 * note: 方法二更为巧妙, 减少了重复递归的过程, 只进行了一次递归, 重复的是计算路径和的过程, 提高运行速度
 * path: https://leetcode.com/problems/path-sum-iii/description/
 * level: easy
 **/
public class Question437 {
    /**
     * 采用递归来遍历
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    private int pathSumFrom(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        return (node.val == sum ? 1 : 0)
                + pathSumFrom(node.left, sum - node.val) + pathSumFrom(node.right, sum - node.val);
    }

    /**
     * 思路二：递归, 首先求出树的高度, 依次遍历, path用来记录当前从根节点到此节点的路径上的值
     *        相加的过程从子节点往上加, 不会缺少从非根节点出发的路径
     */
    public int pathSum2(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int depth = findDepth(root);
        int[] path = new int[depth];
        return helper(root, path, sum, 0);
    }

    private int helper(TreeNode cur, int[] path, int sum, int level) {
        if (cur == null) {
            return 0;
        }
        path[level] = cur.val;
        int count = 0, pathSum = 0;
        for (int i = level; i >= 0; i--) {
            pathSum += path[i];
            if (pathSum == sum) {
                count++;
            }
        }
        count += helper(cur.left, path, sum, level + 1);
        count += helper(cur.right, path, sum, level + 1);
        return count;
    }

    private int findDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return 1 + Math.max(findDepth(root.left), findDepth(root.right));
    }

    public static void main(String[] args) {
        Question437 q = new Question437();
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        TreeNode f = new TreeNode(11);
        TreeNode g = new TreeNode(3);
        TreeNode h = new TreeNode(-2);
        TreeNode i = new TreeNode(1);
        a.left = b;
        b.left = c;
        c.left = d;
        d.left = e;
        System.out.println(q.pathSum(a, 3));
    }
}
