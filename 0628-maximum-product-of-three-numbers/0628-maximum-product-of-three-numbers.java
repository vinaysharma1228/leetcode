import java.util.Arrays;

class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        // Calculate two potential maximum products
        int maxProduct1 = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int maxProduct2 = nums[0] * nums[1] * nums[n - 1];

        // Return the maximum of the two potential maximum products
        return Math.max(maxProduct1, maxProduct2);
    }
}
