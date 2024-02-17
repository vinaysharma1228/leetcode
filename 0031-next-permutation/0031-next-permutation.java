class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;
        
        // Find the first pair (i, i+1) such that nums[i] < nums[i+1]
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // If no such pair found, reverse the entire array
        if (i == -1) {
            reverse(nums, 0, n - 1);
            return;
        }
        
        // Find the smallest element to the right of i and greater than nums[i]
        int j = n - 1;
        while (nums[j] <= nums[i]) {
            j--;
        }
        
        // Swap nums[i] with the found element
        swap(nums, i, j);
        
        // Reverse the subarray to the right of i
        reverse(nums, i + 1, n - 1);
    }
    
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
