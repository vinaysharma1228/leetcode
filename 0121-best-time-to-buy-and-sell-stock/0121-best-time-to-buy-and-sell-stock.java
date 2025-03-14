class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int buyPrices = Integer.MAX_VALUE;

        for(int i=0;i<prices.length;i++){
            if(buyPrices < prices[i]){
                int profit = prices[i]-buyPrices;
                maxProfit=Math.max(maxProfit, profit);
            }
            else{
                buyPrices =prices[i];
            }
        }
        return maxProfit;
    }
}