import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] divideArray(int[] nums, int k) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i += 3) {
            // Check if current array can be formed
            if (i + 2 < nums.length && nums[i + 2] - nums[i] <= k) {
                List<Integer> currentArray = new ArrayList<>();
                currentArray.add(nums[i]);
                currentArray.add(nums[i + 1]);
                currentArray.add(nums[i + 2]);
                result.add(currentArray);
            } else {
                // If not, return empty array
                return new int[][]{};
            }
        }

        // Convert List<List<Integer>> to int[][]
        int[][] ret = new int[result.size()][3];
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < 3; j++) {
                ret[i][j] = result.get(i).get(j);
            }
        }

        return ret;
    }
}
