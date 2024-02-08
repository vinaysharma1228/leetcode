import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        for (int i = 0; i < wordLength; i++) {
            int left = i, right = i, count = 0;
            Map<String, Integer> currentWordCount = new HashMap<>();

            while (right + wordLength <= s.length()) {
                String currentWord = s.substring(right, right + wordLength);
                right += wordLength;

                if (wordCount.containsKey(currentWord)) {
                    currentWordCount.put(currentWord, currentWordCount.getOrDefault(currentWord, 0) + 1);
                    count++;

                    while (currentWordCount.get(currentWord) > wordCount.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength);
                        left += wordLength;
                        currentWordCount.put(leftWord, currentWordCount.get(leftWord) - 1);
                        count--;
                    }

                    if (count == totalWords) {
                        result.add(left);
                    }
                } else {
                    currentWordCount.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}
