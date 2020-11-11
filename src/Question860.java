/**
 * @author Struggle
 * @date Created in 2020/11/11 14:54
 * description Lemonade Change 找零钱 顾客每次固定购买5元的东西，购物所使用的票面金额为5、10、20，判断是否能够对所有顾客进行找零
 * node: 记录5、10面额钱的个数即可，判断当前是否有足够的零钱去支付
 * path: https://leetcode.com/problems/lemonade-change/
 * level: easy
 **/
public class Question860 {
    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length < 1) {
            return true;
        }
        // a 5元的个数
        // b 10元的个数
        int a = 0;
        int b = 0;
        for (int k : bills) {
            if (k == 5) {
                a++;
            } else if (k == 10) {
                if (a >= 1) {
                    a--;
                } else {
                    return false;
                }
                b++;
            } else {
                if (b >= 1 && a >= 1) {
                    b--;
                    a--;
                } else if (a >= 3) {
                    a -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Question860 q = new Question860();
        int[] bills = {5, 5, 10};
        System.out.println(q.lemonadeChange(bills));
    }
}
