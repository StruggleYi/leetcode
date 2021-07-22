package LeetCode;

/**
 * @author Struggle
 * @date Created in 19:11 2020/10/28
 * description ZigZag Conversion  输入一个字符串，将其从上到下按照 丨/ 丨/ 丨/ 型进行排列，行数为K， 排列完成后按每行的先后顺序组成新的字符串
 * path: https://leetcode.com/problems/zigzag-conversion/submissions/
 * level: medium
 **/
public class Question006 {

    /**
     * 解题思路：除了按顺序将字母放到每一行，然后再重新排列得到结果之外
     * 还可以利用数学思路，计算第i个字母最后会出现在哪个位置来计算结果
     * 以丨/ 为一个周期来看，除了第一行和最后一行只会出现一个数字以外，中间都会出现两个数字
     * 第j行的第i个周期中所包含的数为：
     *                  2 * i * (numRows - 1) + (j - 1)
     *                  2 * i * (numRows - 1) + (2 * numRows - j - 1)
     *  其中j是从1开始计算, i是从0开始计算, 当j = 1 和 numRows 时注意只取一个值
     */
    public String convert(String s, int numRows) {
        if (numRows == 1){
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int j = 1; j <= numRows; j++) {
            int m = j - 1;
            int n = 2 * numRows - j - 1;
            for (int i = 1; m < s.length(); i++) {
                //第一行和最后一行支取一个值
                if (j == 1 || j == numRows){
                    sb.append(s.charAt(m));
                }
                //判断每行的第二个数是否超过字符串的最大值
                else if (n < s.length()){
                    sb.append(s.charAt(m));
                    sb.append(s.charAt(n));
                }else {
                    sb.append(s.charAt(m));
                }
                m = 2 * i * (numRows - 1) + (j - 1);
                n = 2 * i * (numRows - 1) + (2 * numRows - j - 1);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Question006 q = new Question006();
        String s = "A";
        System.out.println(q.convert(s, 1));
        System.out.println("PAHNAPLSIIGYIR");
    }
}
