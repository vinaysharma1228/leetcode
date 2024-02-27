

class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> occurrences = new HashMap<>();
        int goodPairs = 0;

        for (int num : nums) {
            
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }


        for (int count : occurrences.values()) {
        
            goodPairs += (count * (count - 1)) / 2;
        }

        return goodPairs;
    }
}
