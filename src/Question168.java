/**
 * @author Struggle
 * @date Created in 22:51 2021/6/29
 * description Excel表列名称
 * node:
 * path: https://leetcode-cn.com/problems/excel-sheet-column-title/
 * level: easy
 **/
public class Question168 {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber > 0) {
            int k = columnNumber % 26;
            if (k == 0){
                k = 26;
                columnNumber = columnNumber / 26 - 1;
            }else {
                columnNumber /= 26;
            }
            sb.append((char) (64 + k));

        }
        return sb.reverse().toString();
    }
}
