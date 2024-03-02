class Solution {
    public int[] sortedSquares(int[] nums) {
        int result[]=new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            int pValue=Math.abs(nums[i]);

            int square=pValue * pValue;

            result[i]=square;
        }
        Arrays.sort(result);
        return result;
    }
}