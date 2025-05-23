class Solution {
    public String mergeAlternately(String word1, String word2) {
         StringBuilder sb = new StringBuilder();

        if (word1.length() < word2.length()) {
            for (int i = 0; i < word1.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            int idx=word1.length();
            while (idx < word2.length()) {
                sb.append(word2.charAt(idx));
                idx++;
            }
        } else {

            for (int i = 0; i < word2.length(); i++) {
                sb.append(word1.charAt(i));
                sb.append(word2.charAt(i));
            }
            int idx=word2.length();
            while (idx < word1.length()) {
                sb.append(word1.charAt(idx));
                idx++;
            }

        }

        return sb.toString();
    }
}