class Solution {
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
        {
            return false;
        }
        return n > 0 && (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }
}

/*

public class Solution {
    public boolean isPowerOfThree(int n) {
        // Base case: if n is not positive, it's not a power of three
        if (n <= 0) {
            return false;
        }

        // Keep dividing n by 3 until it is no longer divisible by 3
        while (n % 3 == 0) {
            n /= 3;
        }

        // If n becomes 1, it was a power of three
        return n == 1;
    }





*/