class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max=Integer.MIN_VALUE;

        List<Boolean> results=new ArrayList<>();

        for(int i=0;i<candies.length;i++)
        {
            max=Math.max(candies[i],max);
        }

        for(int i=0;i<candies.length;i++)
        {
            if(candies[i]+extraCandies >=max)
            {
                results.add(true);
            }
            else{
                results.add(false);
            }
        }

        return results;
    }
}