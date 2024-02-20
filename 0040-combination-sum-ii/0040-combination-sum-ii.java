
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        Arrays.sort(candidates); 
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            if (candidates[i] <= remainingTarget) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, remainingTarget - candidates[i], i + 1, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
