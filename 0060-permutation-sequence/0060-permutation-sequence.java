class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int[] factorial = new int[n + 1];
        factorial[0] = 1;

        // Create a list of numbers from 1 to n
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
            factorial[i] = factorial[i - 1] * i;
        }

        // Adjust k to be 0-based
        k--;

        StringBuilder result = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            int index = k / factorial[i];
            k %= factorial[i];
            result.append(numbers.remove(index));
        }

        return result.toString();
    }
}
