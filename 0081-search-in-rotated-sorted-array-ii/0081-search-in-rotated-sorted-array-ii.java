class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return true;
            }
            
            // Skip duplicates on both ends
            while (left < mid && nums[left] == nums[mid]) {
                left++;
            }
            while (mid < right && nums[mid] == nums[right]) {
                right--;
            }
            
            // Check which part of the array is sorted
            if (nums[left] <= nums[mid]) { // Left part is sorted
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else { // Right part is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return false;
    }
}
