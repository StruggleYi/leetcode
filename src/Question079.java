/**
 * @author Struggle
 * @date Created in 10:07 2019/11/13
 * description Word Search 给定一个二维数组, 其中包含有字母, 判断给定的一个字符串(单词)是否可以由数组的某一条路径产生, 不可重复使用
 * path: https://leetcode.com/problems/word-search/
 * level: medium
 **/
public class Question079 {

    /**
     * 个人递归写法
     */
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) {
            return true;
        }

        boolean[][] flag = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != word.charAt(0)) {
                    continue;
                }
                flag[i][j] = true;
                if (fun(board, word, flag, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean fun(char[][] board, String word, boolean[][] flag, int i, int j) {
        if (word.length() == 1) {
            return true;
        }

        if (i - 1 >= 0 && !flag[i - 1][j] && board[i - 1][j] == word.charAt(1)) {
            flag[i - 1][j] = true;
            if (fun(board, word.substring(1), flag, i - 1, j)) {
                return true;
            }
            flag[i - 1][j] = false;
        }

        if (i + 1 < board.length && !flag[i + 1][j] && board[i + 1][j] == word.charAt(1)) {
            flag[i + 1][j] = true;
            if (fun(board, word.substring(1), flag, i + 1, j)) {
                return true;
            }
            flag[i + 1][j] = false;
        }

        if (j - 1 >= 0 && !flag[i][j - 1] && board[i][j - 1] == word.charAt(1)) {
            flag[i][j - 1] = true;
            if (fun(board, word.substring(1), flag, i, j - 1)) {
                return true;
            }
            flag[i][j - 1] = false;
        }

        if (j + 1 < board[0].length && !flag[i][j + 1] && board[i][j + 1] == word.charAt(1)) {
            flag[i][j + 1] = true;
            if (fun(board, word.substring(1), flag, i, j + 1)) {
                return true;
            }
            flag[i][j + 1] = false;
        }

        flag[i][j] = false;
        return false;
    }

    /**
     * 参考深度优先遍历写法, 这里省略一个标志位记录已走过的路程
     */
    public boolean exist2(char[][] board, String word){
        if (board == null || board.length == 0 || board[0].length == 0) {
            return false;
        }

        if (word == null || word.length() == 0) {
            return true;
        }

        for (int i = 0; i < board.length; i ++){
            for (int j = 0; j < board[0].length; j ++){
                if (board[i][j] == word.charAt(0) && dfs(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k){
        if (k == word.length()){
            return true;
        }

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(k)){
            return false;
        }

        char temp = board[i][j];
        //把该位置标记为已访问
        board[i][j] = '*';

        boolean flag = dfs(board, word, i - 1, j , k + 1) || dfs(board, word, i +1, j , k + 1) ||
                dfs(board, word, i , j - 1, k + 1) || dfs(board, word, i , j + 1, k + 1);

        board[i][j] = temp;
        return flag;
    }

    public static void main(String[] args) {
        Question079 q = new Question079();
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(q.exist(board, "ABCB"));
    }
}
