package LeetCode;

/**
 * @author Struggle
 * @date Created in 2020/11/4 16:12
 * description Valid Sudoku 判断数独是否有解
 * node: 官方的思路：判断一个数独是否有解，不需要对空白位置的内容进行填补
 *                  判断每一行、每一列、每9个小格之内的已有数符合要求即可
 * path: https://leetcode.com/problems/valid-sudoku/
 * level: medium
 **/
public class Question036 {

    public boolean isValidSudoku(char[][] board) {
        // r记录每行1-9的出现情况
        // c记录每列1-9的出现情况
        int[][] r = new int[9][9];
        int[][] c = new int[9][9];

        //每次遍历一个九方格
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {
                int[] block = new int[9];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        if (board[k][l] == '.') {
                            continue;
                        }
                        int currentDigit = board[k][l] - '0' - 1;
                        if (block[currentDigit] == 1 || r[k][currentDigit] == 1 || c[l][currentDigit] == 1) {
                            return false;
                        } else {
                            r[k][currentDigit] = 1;
                            c[l][currentDigit] = 1;
                            block[currentDigit] = 1;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question036 q = new Question036();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(q.isValidSudoku(board));
    }
}
