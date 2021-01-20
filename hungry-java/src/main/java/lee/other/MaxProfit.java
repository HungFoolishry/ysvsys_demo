package lee.other;

/**
 * description: 股票最大利润
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @author JunchaoYao
 * @date 2020-10-20 13:39
 **/
public class MaxProfit {
    class Solution {
        public int maxProfit(int[] prices) {
            // 历史记录最大利润变量
            int max = 0;
            int min = Integer.MAX_VALUE;
            for (int price : prices) {

                if (price < min) {
                    //寻找最低点
                    min = price;
                }
                if (max < price - min) {
                    //最大值更新
                    max = price - min;
                }
            }
            return max;

        }
    }
//    public class Solution {
//        public int maxProfit(int prices[]) {
//            int minprice = Integer.MAX_VALUE;
//            int maxprofit = 0;
//            for (int i = 0; i < prices.length; i++) {
//                if (prices[i] < minprice) {
//                    minprice = prices[i];
//                } else if (prices[i] - minprice > maxprofit) {
//                    maxprofit = prices[i] - minprice;
//                }
//            }
//            return maxprofit;
//        }
//    }


}
