package LeetCode;

/**
 * @author Struggle
 * @date Created in 9:54 2019/10/23
 * description  Best Time to Buy and Sell Stock II  多次交易 获取最大利益
 **/
public class Question122 {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int price = 0;
        int i = 0;
        while (i < prices.length) {
            int min = Integer.MAX_VALUE;
            while (i < prices.length && min > prices[i]) {
                min = prices[i++];
            }
            int max = min;
            while (i < prices.length && max <= prices[i]){
                max = prices[i++];
            }

            price += max - min;
        }
        return price;
    }

    public static void main(String[] args) {
        Question122 q = new Question122();
        int[] price = {1, 2, 3, 4, 5};
        System.out.println(q.maxProfit(price));
    }
}
