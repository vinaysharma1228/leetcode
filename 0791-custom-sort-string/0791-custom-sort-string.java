
class Solution {
    public String customSortString(String order, String s) {
        // Create an array to store the order of each character
        int[] charOrder = new int[26];
        
        // Assign the order for each character based on the given order string
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }
        
        // Convert string s to character array for sorting
        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }
        
        // Sort the characters using a custom comparator
        Arrays.sort(charArray, new Comparator<Character>() {
            @Override
            public int compare(Character c1, Character c2) {
                return Integer.compare(charOrder[c1 - 'a'], charOrder[c2 - 'a']);
            }
        });
        
        // Convert the sorted character array back to a string
        StringBuilder result = new StringBuilder();
        for (Character c : charArray) {
            result.append(c);
        }
        
        return result.toString();
    }
}
