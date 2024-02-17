import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateParenthesisHelper(n, 0, 0, "", result);
        return result;
    }

    private void generateParenthesisHelper(int n, int open, int close, String current, List<String> result) {
        // Base case: if the current combination is valid, add it to the result
        if (current.length() == 2 * n) {
            result.add(current);
            return;
        }

        // Add an open parenthesis if the count of open parentheses is less than n
        if (open < n) {
            generateParenthesisHelper(n, open + 1, close, current + "(", result);
        }

        // Add a close parenthesis if the count of close parentheses is less than open parentheses
        if (close < open) {
            generateParenthesisHelper(n, open, close + 1, current + ")", result);
        }
    }
}
