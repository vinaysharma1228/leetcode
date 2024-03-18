
class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points == null || points.length == 0) return 0;
        
        // Sort the balloons by their start points
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        
        int arrows = 1;
        int end = points[0][1];
        
        for (int i = 1; i < points.length; i++) {
            // If the current balloon overlaps with the previous one,
            // update the end point to the minimum end point of both balloons
            if (points[i][0] <= end) {
                end = Math.min(end, points[i][1]);
            } else {
                // If the current balloon does not overlap with the previous one,
                // we need another arrow, update the end point
                arrows++;
                end = points[i][1];
            }
        }
        
        return arrows;
    }
}
