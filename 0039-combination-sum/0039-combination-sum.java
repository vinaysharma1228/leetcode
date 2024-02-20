import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentCombination = new ArrayList<>();
        backtrack(candidates, target, 0, currentCombination, result);
        return result;
    }

    private void backtrack(int[] candidates, int remainingTarget, int start, List<Integer> currentCombination, List<List<Integer>> result) {
        if (remainingTarget == 0) {
            result.add(new ArrayList<>(currentCombination));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] <= remainingTarget) {
                currentCombination.add(candidates[i]);
                backtrack(candidates, remainingTarget - candidates[i], i, currentCombination, result);
                currentCombination.remove(currentCombination.size() - 1);
            }
        }
    }
}
