
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean[] used = new boolean[nums.length];

        Arrays.sort(nums);

        generatePermutations(nums, used, currentPermutation, result);

        return result;
    }

    private void generatePermutations(int[] nums, boolean[] used, List<Integer> currentPermutation, List<List<Integer>> result) {
        if (currentPermutation.size() == nums.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }

            used[i] = true;
            currentPermutation.add(nums[i]);

            generatePermutations(nums, used, currentPermutation, result);

            used[i] = false;
            currentPermutation.remove(currentPermutation.size() - 1);
        }
    }
}
