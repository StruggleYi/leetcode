package questionafter1000;

/**
 * @author Struggle
 * @date Created in 20:39 2021/1/14
 * description Alphabet Board Path 26个字母组成的棋盘，U D L F 分别代表上下左右，给定字符串，寻找到从a 依次走到字符串每个字母的路径
 * node: 最短路径不唯一, 返回其中一个即可, 此题需要注意的点是, 当从z出发时不可向右移动, 到达z时, 注意最后一行只有一个字母
 * path: https://leetcode.com/problems/alphabet-board-path/
 * level: medium
 **/
public class Question1138 {
    public String alphabetBoardPath(String target) {
        if (target == null || target.length() == 0){
            return "";
        }

        StringBuilder sb = new StringBuilder();

        int i = 0;
        int j = 0;
        int m;
        int n;
        for (int k = 0; k < target.length(); k++){
            int num = target.charAt(k) - 'a';

            m = num / 5;
            n = num % 5;

            // 当目标是z时, 先横向移动, 再竖向移动
            if (m == 5){
                lateralMovement(j, n, sb);
                longitudinalMovement(i, m, sb);
            }else {
                // 否则先竖向移动, 再横向移动
                longitudinalMovement(i, m, sb);
                lateralMovement(j, n, sb);
            }

            sb.append("!");
            i = m;
            j = n;
        }

        return sb.toString();
    }

    /**
     * 横向移动
     * @param j
     * @param n
     * @param sb
     */
    private void lateralMovement(int j, int n, StringBuilder sb){
        if (j > n){
            int t = j - n;
            while (t-- > 0){
                sb.append("L");
            }
        }else if (j < n){
            int t = n - j;
            while (t-- > 0){
                sb.append("R");
            }
        }
    }

    /**
     * 纵向移动
     * @param i
     * @param m
     * @param sb
     */
    private void longitudinalMovement(int i, int m, StringBuilder sb){
        if (i > m){
            int t = i - m;
            while (t-- > 0){
                sb.append("U");
            }
        }else if (i < m){
            int t = m - i;
            while (t-- > 0){
                sb.append("D");
            }
        }
    }

    public static void main(String[] args) {
        Question1138 q = new Question1138();

        System.out.println(q.alphabetBoardPath("zdz"));
    }
}
