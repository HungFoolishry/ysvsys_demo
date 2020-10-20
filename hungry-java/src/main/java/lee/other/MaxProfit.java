package lee.other;

/**
 * description: 股票最大利润
 *
 * @author JunchaoYao
 * @date 2020-10-20 13:39
 **/
public class MaxProfit {
    public static int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minPrice = prices[0];
        int profitMax = 0;

        for (int price : prices) {
            minPrice = Math.min(price, minPrice);
            profitMax = Math.max(price - minPrice, profitMax);
        }
        return profitMax;

    }

    public static void main(String[] args) {
        int[] prices = {};
        maxProfit(prices);
    }
}
