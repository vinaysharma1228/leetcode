class Solution {
    public int maxProfit(int[] prices) {
         if (prices == null || prices.length <= 1) {
            return 0;
        }

        int buyPrice=Integer.MAX_VALUE;
        int maxProfit=0;

        for(int i=0;i<prices.length;i++)
        {
            if(buyPrice < prices[i])
            {
                int profit=prices[i]-buyPrice;

                maxProfit=Math.max(maxProfit,profit);
            }
            else{
                buyPrice=prices[i];
            }
        }

        return maxProfit;
        
    }
}