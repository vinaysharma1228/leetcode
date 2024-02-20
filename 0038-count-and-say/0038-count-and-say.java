class Solution {
    public String countAndSay(int n) {
        // Base case
        if (n == 1) {
            return "1";
        }

        // Recursively get the (n-1)th term
        String previousTerm = countAndSay(n - 1);
        
        // Build the current term
        StringBuilder currentTerm = new StringBuilder();
        int count = 1;
        
        // Iterate through the previous term
        for (int i = 0; i < previousTerm.length(); i++) {
            // If the current digit is the same as the next one, increment count
            if (i < previousTerm.length() - 1 && previousTerm.charAt(i) == previousTerm.charAt(i + 1)) {
                count++;
            } else {
                // Append count and digit to the current term
                currentTerm.append(count).append(previousTerm.charAt(i));
                // Reset count for the new digit
                count = 1;
            }
        }

        return currentTerm.toString();
    }
}
