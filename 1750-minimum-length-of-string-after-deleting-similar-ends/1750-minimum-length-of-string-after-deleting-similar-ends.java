class Solution {
    public int minimumLength(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right && s.charAt(left) == s.charAt(right)) {
            char currentChar = s.charAt(left);
            while (left <= right && s.charAt(left) == currentChar) {
                left++;
            }
            while (right >= left && s.charAt(right) == currentChar) {
                right--;
            }
        }

        return Math.max(0, right - left + 1);
    }
}
