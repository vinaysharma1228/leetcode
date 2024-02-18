class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        // Find the starting position
        int start = binarySearch(nums, target, true);
        if (start == -1) {
            return result; // Target not found
        }

        // Find the ending position
        int end = binarySearch(nums, target, false);

        result[0] = start;
        result[1] = end;
        return result;
    }

    private int binarySearch(int[] nums, int target, boolean findStart) {
        int left = 0;
        int right = nums.length - 1;
        int result = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                result = mid;

                if (findStart) {
                    // Look for the target in the left half
                    right = mid - 1;
                } else {
                    // Look for the target in the right half
                    left = mid + 1;
                }
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}
