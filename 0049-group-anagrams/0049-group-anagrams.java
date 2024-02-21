class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       

        List<List<String>> res = new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s: strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);

            //if it contains the key
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);

        }

        return new ArrayList(map.values());

    }

    
}