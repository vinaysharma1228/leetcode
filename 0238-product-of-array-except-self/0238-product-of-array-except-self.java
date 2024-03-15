class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        
        int[] prefixProducts = new int[n];
        prefixProducts[0] = 1;
        for (int i = 1; i < n; i++) {
            prefixProducts[i] = prefixProducts[i - 1] * nums[i - 1];
        }
       
        int suffixProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = prefixProducts[i] * suffixProduct;
            suffixProduct *= nums[i];
        }
        
        return answer;
    }
}
