package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:09 2021/7/30
 * description  Excel 表列序号  给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号
 * node:
 * path: https://leetcode-cn.com/problems/excel-sheet-column-number/
 * level: easy
 **/
public class Question171 {

    public int titleToNumber(String columnTitle) {
        int res = 0;

        for (int i = 0; i < columnTitle.length(); i++) {
            res = res * 26 + (columnTitle.charAt(i) - 'A' + 1);
        }

        return res;
    }
}
