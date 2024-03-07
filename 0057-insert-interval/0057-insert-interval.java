
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int i = 0;

        // Add intervals that come before newInterval
        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // Merge overlapping intervals with newInterval
        while (i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }

        // Add the merged interval
        result.add(newInterval);

        // Add remaining intervals that come after newInterval
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        // Convert the result to a 2D array
        return result.toArray(new int[result.size()][]);
    }
}
