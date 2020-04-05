/*
 *	Say you have an array for which the ith element is the price of a given stock on day i.
 *	Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock 
 *	multiple times).
 *
 *	Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 *
 *	Example 1:
 *
 *	Input: [7,1,5,3,6,4]
 *	Output: 7
 *	Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 *  			 Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 *	Example 2:
 *
 *	Input: [1,2,3,4,5]
 *	Output: 4
 *	Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 *  			 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 *  			 engaging multiple transactions at the same time. You must sell before buying again.
 *	
 *	Example 3:
 *
 *	Input: [7,6,4,3,1]
 *	Output: 0
 *	Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
 class Solution {
    public int maxProfit(int[] prices) {
        int curr_profit = 0;
        int max_profit = 0;
        if(prices.length == 0) return 0;
        int curr_buy = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(curr_buy > prices[i]) {
                curr_buy = prices[i];
                max_profit += curr_profit;
                curr_profit = 0;
            }
            else {
                int profit = prices[i] - curr_buy;
                if(curr_profit < profit) {
                    curr_profit = profit;
                } else {
                    max_profit += curr_profit;
                    curr_profit = 0;
                    curr_buy = prices[i];
                }
            }
        }
        if(curr_profit != 0) max_profit += curr_profit;
        
        return max_profit;
    }
}