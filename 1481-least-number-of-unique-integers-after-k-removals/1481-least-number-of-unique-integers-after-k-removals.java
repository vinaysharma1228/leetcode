
class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // Count the frequency of each element
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Sort the elements based on their frequencies
        List<Map.Entry<Integer, Integer>> sortedFrequencies = new ArrayList<>(frequencyMap.entrySet());
        sortedFrequencies.sort(Map.Entry.comparingByValue());

        int uniqueCount = frequencyMap.size();

        // Iterate through sorted frequencies and remove elements until k is reached
        for (Map.Entry<Integer, Integer> entry : sortedFrequencies) {
            int frequency = entry.getValue();
            if (k >= frequency) {
                k -= frequency;
                uniqueCount--;
            } else {
                break;
            }
        }

        return uniqueCount;
    }
}
