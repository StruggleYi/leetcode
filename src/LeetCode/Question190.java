package LeetCode;

/**
 * @author Struggle
 * @date Created in 10:30 2019/10/28
 * description  Reverse Bits  将32位无符号整形翻转
 **/
public class Question190 {

    public int reverseBits(int n) {
        int result = 0;
        int i = 32;
        // n与1 进行 与 运算可以得到最后一位数字, 与此同时可以将该数字赋给result, result进行左移操作, 则相当于数字翻转
        while (--i >= 0) {
            result = result << 1;
            result += n & 1;
            n = n >> 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Question190 q = new Question190();
        System.out.println(q.reverseBits(43261596));
    }
}
