
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        HashMap<Character, Integer> charIndexMap = new HashMap<>();

        for (int i = 0, j = 0; j < n; j++) {
            char currentChar = s.charAt(j);

            if (charIndexMap.containsKey(currentChar)) {
                i = Math.max(charIndexMap.get(currentChar) + 1, i);
            }

            maxLength = Math.max(maxLength, j - i + 1);
            charIndexMap.put(currentChar, j);
        }

        return maxLength;
    }
}
