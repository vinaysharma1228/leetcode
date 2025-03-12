class Solution {
    public int maxSubArray(int[] nums) {
         int cs =0;
         int ms = Integer.MIN_VALUE;

         for(int i=0;i<nums.length;i++){
            cs = cs + nums[i];

            if(cs < 0){
                cs = 0;
            }
            ms = Math.max(cs,ms);
         }

         if(ms==0){
                int m = Integer.MIN_VALUE;
                for(int i=0;i<nums.length;i++){
                    m = Math.max(m,nums[i]);
                }
                ms = m;
            }
         return ms;
    }
}