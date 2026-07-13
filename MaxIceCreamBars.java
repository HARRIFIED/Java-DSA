/*
    1833. Maximum Ice Cream Bars
    It is a sweltering summer day, and a boy wants to buy some ice cream bars.
    At the store, there are n ice cream bars. You are given an array costs of length n, where costs[i] is the price of the ith ice cream bar in coins. 
    The boy initially has coins coins to spend, and he wants to buy as many ice cream bars as possible. 

    Note: The boy can buy the ice cream bars in any order.

    Return the maximum number of ice cream bars the boy can buy with coins coins.

    You must solve the problem by counting sort.
    
    Example 1:
    Input: costs = [1,3,2,4,1], coins = 7
    Output: 4
    Explanation: The boy can buy ice cream bars at indices 0,1,2,4 for a total price of 1 + 3 + 2 + 1 = 7.

    Constraints:
    costs.length == n
    1 <= n <= 105
    1 <= costs[i] <= 105
    1 <= coins <= 108
 */

public class MaxIceCreamBars {
    public int solution (int[] costs, int coins) {
        int maxIcreamBought = 0;
        int max = 100000; //highest number in the costs range given from constraint
        int[] count = new int[max + 1]; // to build counting array for counting sort

        //build the count array 
        for (int cost : costs) {
            count[cost]++;
        }
        
        for (int price = 1; price < max; price++) {
            if (count[price] == 0) continue; // no ice cream bar with that bar exist
            if (coins < price) break; // cannot afford anything beyond here

            int canBuy = Math.min(count[price], coins/price); // how much we can buy from existing price
            maxIcreamBought += canBuy; // increase with the number of bars bought for that price
            coins -= price * canBuy; // substract the amount from coins
        }

        return maxIcreamBought;
    } 
}
