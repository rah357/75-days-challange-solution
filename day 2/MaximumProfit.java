public class MaximumProfit {
    public static void main(String[] args) {
        int stockPrices[] = new int[] { 7, 5, 4, 1, 5, 3, 6, 4, 3, 4, 6, 7 };
        Solution solution = new Solution();

        int maxProfit = solution.maxProfit(stockPrices);

        System.out.println("maxProfit is = " + maxProfit);

    }

}

class Solution {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int profit = 0;
        int tempProfit = 0;
        int buy = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            } else if (buy < prices[i]) {
                if ((prices[i] - buy) > tempProfit) {
                    tempProfit = prices[i] - buy;
                } else if ((prices[i] - buy) < tempProfit) {
                    profit += tempProfit;
                    tempProfit = 0;
                    buy = prices[i];
                }

            }
            if (prices[i] < prices[i - 1]) {
                profit += tempProfit;
                tempProfit = 0;
            }

        }

        if (tempProfit > 0) {
            profit += tempProfit;

        }
        return profit;
    }
}