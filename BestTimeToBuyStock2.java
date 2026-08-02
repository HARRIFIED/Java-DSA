/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.

    On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of
     the stock at any time. However, you can sell and buy the stock multiple times on the same day, 
     ensuring you never hold than one share of the stock.

    Find and return the maximum profit you can achieve.

    /**
    [ 7, 1, 5, 3, 6, 4 ]
                  L
                     R

    output = 0 + 4 + 3 = 7

    [1, 2, 3, 4, 5]
        L
           R
    
     Output = 0 + 1 + 1 + 1 + 1 = 4

 */

public class BestTimeToBuyStock2 {
    public int solution(int[] prices) {
        int left = 0;
        int totalProfit = 0;

        for (int right = 1; right < prices.length; right++) {
            if (prices[right] > prices[left]) {
                totalProfit += (prices[right] - prices[left]);
            }
            left++;
        }
        return totalProfit;
    }
}
