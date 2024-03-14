import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> sumFrequency = new HashMap<>();
        sumFrequency.put(0, 1); // Initialize with 0 sum frequency 1

        for (int num : nums) {
            sum += num;
            // Check if the current sum minus the goal is present in the map
            // If yes, add its frequency to the count
            if (sumFrequency.containsKey(sum - goal))
                count += sumFrequency.get(sum - goal);
            // Update the frequency of the current sum
            sumFrequency.put(sum, sumFrequency.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
