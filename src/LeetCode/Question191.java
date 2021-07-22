package LeetCode;

/**
 * @author Struggle
 * @date Created in 11:06 2019/10/28
 * description Number of 1 Bits 无符号32位整数中1的个数
 **/
public class Question191 {

    public int hammingWeight(int n) {
        int sum = 0;
        while (n != 0) {
            n = n & (n - 1);
            sum ++;
        }
        return sum;
    }

    public static void main(String[] args) {
        Question191 q = new Question191();
        System.out.println(q.hammingWeight(3));
    }
}
