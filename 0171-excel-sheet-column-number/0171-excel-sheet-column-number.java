class Solution {
    public int titleToNumber(String columnTitle) {
        int result = 0;
        
        for (int i = 0; i < columnTitle.length(); i++) {
            char currentChar = columnTitle.charAt(i);
            int numericValue = currentChar - 'A' + 1; 
            result = result * 26 + numericValue; 
        }
        
        return result;
    }
}
