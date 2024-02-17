class Solution {
    public String convertToTitle(int columnNumber) {
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            // Adjusting to 0-based index
            columnNumber--;

            char digit = (char) ('A' + columnNumber % 26);
            result.insert(0, digit);

            columnNumber /= 26;
        }

        return result.toString();
    }
}
