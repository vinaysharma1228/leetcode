class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) {
            return true;
        }
        if ((maxChoosableInteger * (maxChoosableInteger + 1)) / 2 < desiredTotal) {
            return false; // Sum of all numbers is less than desiredTotal
        }
        return canIWin(0, maxChoosableInteger, desiredTotal, new Boolean[1 << maxChoosableInteger]);
    }
    
    private boolean canIWin(int usedNumbers, int maxChoosableInteger, int desiredTotal, Boolean[] memo) {
        if (memo[usedNumbers] != null) {
            return memo[usedNumbers];
        }
        for (int i = 1; i <= maxChoosableInteger; i++) {
            int currentMask = 1 << (i - 1);
            if ((usedNumbers & currentMask) == 0) { // Number i not used
                if (i >= desiredTotal || !canIWin(usedNumbers | currentMask, maxChoosableInteger, desiredTotal - i, memo)) {
                    memo[usedNumbers] = true;
                    return true;
                }
            }
        }
        memo[usedNumbers] = false;
        return false;
    }
}