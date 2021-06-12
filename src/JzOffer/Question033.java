package JzOffer;

/**
 * @author Struggle
 * @date Created in 23:55 2021/6/12
 * description 二叉搜索树的后序遍历序列  输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false  假设输入的数组的任意两个数字都互不相同
 * node: 后续遍历是 左子树 右子树 根节点 因为该二叉树是搜索树, 所以左子树比根节点的值都要小, 右子树比根节点的值都要大
 * path: https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/
 * level: medium
 **/
public class Question033 {

    public boolean verifyPostorder(int[] postorder) {

        // 长度为0或者1返回true
        int len = postorder.length;
        if (len == 0 || len == 1) {
            return true;
        }
        return help(postorder, 0, len - 1);
    }

    public boolean help(int[] postorder, int m, int n) {

        // 长度为1或者子树不存在的情况
        if (m >= n) {
            return true;
        }

        int root = postorder[n];

        // 取出左子树的值, 遍历所有比根节点小的值
        int i = 0;
        while (i < n) {
            if (postorder[i] < root) {
                i++;
            } else {
                break;
            }
        }

        // 取出右子树的值, 遍历所有比根节点大的值
        int j = i;
        while (j < n) {
            if (postorder[j] > root) {
                j++;
            } else {
                break;
            }
        }

        // 如果有剩余的数未被取出, 表示不能复原成搜索二叉树, 然后递归判断左子树和右子树是否满足条件
        return j == n && help(postorder, m, i - 1) && help(postorder, i, n - 1);
    }
}
