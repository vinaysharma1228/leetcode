import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int maxChoosableInteger = 11;
        int desiredTotal = 11;
        System.out.println(canIWin(maxChoosableInteger, desiredTotal)); // Output: false
    }

    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) return true;
        if ((maxChoosableInteger + 1) * maxChoosableInteger / 2 < desiredTotal) return false;
        Map<Integer, Boolean> memo = new HashMap<>();
        return canWin(0, 0, maxChoosableInteger, desiredTotal, memo);
    }

    private static boolean canWin(int state, int total, int maxChoosableInteger, int desiredTotal, Map<Integer, Boolean> memo) {
        if (total >= desiredTotal) return false;
        if (memo.containsKey(state)) return memo.get(state);
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int mask = 1 << i;
            if ((state & mask) == 0) {
                int next = state | mask;
                if (!canWin(next, total + i, maxChoosableInteger, desiredTotal, memo)) {
                    memo.put(state, true);
                    return true;
                }
            }
        }
        memo.put(state, false);
        return false;
    }
}
