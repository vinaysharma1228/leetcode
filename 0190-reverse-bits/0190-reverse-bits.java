public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            // Shift result to the left to make space for the next bit
            result <<= 1;
            // Extract the rightmost bit of n and add it to the result
            result |= (n & 1);
            // Shift n to the right to process the next bit
            n >>>= 1;
        }
        return result;
    }
}
