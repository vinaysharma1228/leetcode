class Solution {
    public List<Integer> intersection(int[][] nums) {
        // Create a HashMap to store the count of each element in the first array
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums[0]) {
            countMap.put(num, 1);
        }

        // Iterate through the remaining arrays and update the count of common elements
        for (int i = 1; i < nums.length; i++) {
            countMap = updateCountMap(countMap, nums[i]);
        }

        // Create a List to store the common elements and add them to the list
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() == nums.length) {
                result.add(entry.getKey());
            }
        }

        // Sort the result list in ascending order
        Collections.sort(result);
        return result;
    }

    private Map<Integer, Integer> updateCountMap(Map<Integer, Integer> countMap, int[] nums) {
        // Create a temporary HashMap to store the updated count
        Map<Integer, Integer> temp = new HashMap<>();

        // Iterate through the current array and update the count of common elements
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                temp.put(num, countMap.get(num) + 1);
            }
        }

        // Return the updated count map
        return temp;
    }
}