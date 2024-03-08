class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Initialize base cases
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= n; j++) {
            dp[0][j] = j;
        }

        // Fill in the matrix using the recurrence relation
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int deletion = dp[i - 1][j] + 1;
                int insertion = dp[i][j - 1] + 1;
                int replacement = dp[i - 1][j - 1] + (word1.charAt(i - 1) == word2.charAt(j - 1) ? 0 : 1);

                dp[i][j] = Math.min(deletion, Math.min(insertion, replacement));
            }
        }

        return dp[m][n];
    }
}
