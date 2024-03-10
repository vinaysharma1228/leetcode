
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int start = 0; // Start index of the current line
        int end = 0;   // End index of the current line

        while (start < words.length) {
            int lineLength = words[start].length(); // Initialize line length with the length of the first word
            end = start + 1;

            // Add words to the line until it exceeds maxWidth
            while (end < words.length && lineLength + words[end].length() + (end - start) <= maxWidth) {
                lineLength += words[end].length();
                end++;
            }

            // Build the justified line
            StringBuilder line = new StringBuilder(words[start]);
            int numberOfWords = end - start - 1; // Number of gaps between words
            int totalSpaces = maxWidth - lineLength; // Total spaces to be distributed

            // If there's only one word or it's the last line, left-justify the line
            if (numberOfWords == 0 || end == words.length) {
                for (int i = start + 1; i < end; i++) {
                    line.append(" ").append(words[i]);
                }
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                // Calculate the number of spaces to be added between each pair of words
                int spacesBetweenWords = totalSpaces / numberOfWords;
                int extraSpaces = totalSpaces % numberOfWords;

                for (int i = start + 1; i < end; i++) {
                    int spacesToAdd = spacesBetweenWords + (i - start <= extraSpaces ? 1 : 0);
                    for (int j = 0; j < spacesToAdd; j++) {
                        line.append(" ");
                    }
                    line.append(words[i]);
                }
            }

            result.add(line.toString());
            start = end; // Move to the next line
        }

        return result;
    }
}
