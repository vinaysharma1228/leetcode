class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) {
                return false; // Cannot reach the current index
            }

            maxReach = Math.max(maxReach, i + nums[i]);

            if (maxReach >= nums.length - 1) {
                return true; // Reached the last index
            }
        }

        return false; // Unable to reach the last index
    }
}
