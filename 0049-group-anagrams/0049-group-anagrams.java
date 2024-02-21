

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
  
        Map<String, List<String>> anagramGroups = new HashMap<>();

     
        for (String str : strs) {
   
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

    
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());

 
            anagramGroups.get(sortedStr).add(str);
        }

        List<List<String>> result = new ArrayList<>(anagramGroups.values());

        return result;
    }
}
