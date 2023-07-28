package com.whl.leekcode.easy;

/**
 * 买卖股票的最佳时机
 * @author liaowenhui
 * @date 2023/6/13 17:16
 */
public class HOT121 {

    /**
     *
     * 用一个变量记录一个历史最低价格 minprice，我们就可以假设自己的股票是在那天买的。
     * 那么我们在第 i 天卖出股票能得到的利润就是 prices[i] - minprice
     *
     * 时间复杂度：O(n)，只需要遍历一次。
     * 空间复杂度：O(1)，只使用了常数个变量。
     * @param prices
     * @return
     */
    public static int maxProfit(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * 100%
     * @param prices
     * @return
     */
    public static int maxProfitTest(int prices[]) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice){
                minPrice = prices[i];
            }else if (prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        System.out.println("利润:" + maxProfitTest(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
