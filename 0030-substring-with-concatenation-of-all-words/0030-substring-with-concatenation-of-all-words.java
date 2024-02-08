
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLength = words[0].length();
        int totalWords = words.length;
        int totalLength = wordLength * totalWords;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        for (int i = 0; i <= s.length() - totalLength; i++) {
            String substring = s.substring(i, i + totalLength);
            Map<String, Integer> currentWordCount = new HashMap<>();

            for (int j = 0; j < totalLength; j += wordLength) {
                String currentWord = substring.substring(j, j + wordLength);
                currentWordCount.put(currentWord, currentWordCount.getOrDefault(currentWord, 0) + 1);
            }

            if (currentWordCount.equals(wordCount)) {
                result.add(i);
            }
        }

        return result;
    }
}
