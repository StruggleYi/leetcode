package LeetCode;

/**
 * @author Struggle
 * @date Created in 23:38 2021/8/17
 * description 学生出勤记录 I  给你一个字符串 s 表示一个学生的出勤记录，其中的每个字符用来标记当天的出勤情况（缺勤、迟到、到场）
 * node:
 * path: https://leetcode-cn.com/problems/student-attendance-record-i/
 * level: easy
 **/
public class Question551 {
    public boolean checkRecord(String s) {
        int countA = 0;
        int countL = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                countA++;
                if (countA > 1) {
                    return false;
                }
            } else if (s.charAt(i) == 'L') {
                if (countL >= 2 && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                    return false;
                }
                countL++;
            }
        }
        return true;

    }
}
