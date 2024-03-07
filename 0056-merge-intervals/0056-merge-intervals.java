
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals;
        }

        // Step 1: Sort the intervals based on start times
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];

        // Step 2: Merge overlapping intervals
        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] >= intervals[i][0]) {
                // Overlapping intervals, merge them
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            } else {
                // Non-overlapping intervals, add the merged interval to the result
                result.add(currentInterval);
                currentInterval = intervals[i];
            }
        }

        // Add the last merged interval to the result
        result.add(currentInterval);

        // Convert the result to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}
