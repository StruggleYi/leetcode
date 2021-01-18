/**
 * @author Struggle
 * @date Created in 19:49 2021/1/18
 * description Compare Version Numbers 比较两个版本号的大小
 * node: 将版本号按照 . 分开，比较每一位的大小即可
 * path: https://leetcode.com/problems/compare-version-numbers/
 * level: medium
 **/
public class Question165 {
    public int compareVersion(String version1, String version2) {
        // 注意拆分字符串时需要将 . 进行转义
        String[] s1 = version1.split("\\.");
        String[] s2 = version2.split("\\.");

        //分别比较每一位的大小
        int i = 0;
        for (; i < s1.length && i < s2.length; i++) {
            int a = Integer.valueOf(s1[i]);
            int b = Integer.valueOf(s2[i]);

            if (a == b) {
                continue;
            }

            return a < b ? -1 : 1;
        }

        // 如果版本号的位数不一致，位数小的版本号默认补0进行判断
        if (s1.length == s2.length){
            return 0;
        }else if (s1.length < s2.length){
            while (i < s2.length){
                int b = Integer.valueOf(s2[i]);
                if (b > 0){
                    return -1;
                }
                i++;
            }
        }else {
            while (i < s1.length){
                int a = Integer.valueOf(s1[i]);
                if (a > 0){
                    return 1;
                }
                i++;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        Question165 q = new Question165();

        System.out.println(q.compareVersion("1.0", "0.0.0"));
    }
}
