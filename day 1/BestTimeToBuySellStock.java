
public class BestTimeToBuySellStock {
    public static void main(String[] args) {
        int arr[] = new int[] { 7, 1, 5, 3, 6, 4 };
        Solution solution = new Solution();
        int maxProfit = solution.maxProfit(arr);

        System.out.println("maxprofit will be = " + maxProfit);

    }
}

class Solution {
    public int maxProfit(int[] stockForDays) {
        int profit = -99999;
        int minPrice = 999999;
        for (int i = 0; i < stockForDays.length; i++) {
            if (stockForDays[i] < minPrice) {
                minPrice = stockForDays[i];
            }
            if (stockForDays[i] - minPrice > profit) {
                profit = stockForDays[i] - minPrice;
            }
        }
        return profit;
    }
}