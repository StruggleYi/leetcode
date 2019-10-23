/**
 * @author Struggle
 * @date Created in 9:32 2019/10/23
 * description  Best Time to Buy and Sell Stock  买入卖出获得利润的最大值
 **/
public class Question121 {
    public int maxProfit(int[] prices) {
        int max = 0;
        int minPrice = Integer.MAX_VALUE;
        int i = -1;
        while (i++ < prices.length - 1){
            int temp = prices[i] - minPrice;
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if (temp > max) {
                max = temp;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Question121 q = new Question121();
        int[] price = {7,1,5,3,6,4};
        System.out.println(q.maxProfit(price));
    }
}
