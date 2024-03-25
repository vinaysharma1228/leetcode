class Solution {
    private static final long MOD = 1000000007;

    public int countVowelPermutation(int n) {
        long[] dp = new long[5];
        dp[0] = 1; // 'a'
        dp[1] = 1; // 'e'
        dp[2] = 1; // 'i'
        dp[3] = 1; // 'o'
        dp[4] = 1; // 'u'

        for (int i = 2; i <= n; i++) {
            long[] next = new long[5];

            // 'a' can be followed by 'e'
            next[0] = (dp[1] + dp[2] + dp[4]) % MOD;

            // 'e' can be followed by 'a' or 'i'
            next[1] = (dp[0] + dp[2]) % MOD;

            // 'i' can be followed by 'e' or 'o'
            next[2] = (dp[1] + dp[3]) % MOD;

            // 'o' can be followed by 'i' or 'u'
            next[3] = dp[2] % MOD;

            // 'u' can be followed by 'a'
            next[4] = (dp[2] + dp[3]) % MOD;

            dp = next;
        }

        long total = 0;
        for (long count : dp) {
            total = (total + count) % MOD;
        }

        return (int) total;
    }
}