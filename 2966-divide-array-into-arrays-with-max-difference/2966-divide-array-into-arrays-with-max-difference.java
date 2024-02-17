class Solution {
    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] result = new int[nums.length/3][3];
        
        for (int i=0,j=0; i< nums.length; i+=3, j++){
            if (nums[i+2]-nums[i]>k) return new int[0][0];
            result[j][0] = nums[i];
            result[j][1] = nums[i+1];
            result[j][2] = nums[i+2];
        }
        return result;
    }
}