class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // SOLUTION 1: 
        // have to use hashmap where key is the different alphabets like "e", "a" and "t" in this case and then put all the values that have these in one list.
        // List<List<String>> res = new ArrayList<>();

        // HashMap<String, List<String>> map = new HashMap<>();
        // for(String s: strs){
        //     char[] arr = s.toCharArray();
        //     Arrays.sort(arr);
        //     String key = new String(arr);
        //     // List<String> list = new ArrayList<>();

        //     // //if it contains the key
        //     // if(map.containsKey(key)){
        //     //     //get the lsit for that key and add the new found anagram to it.
        //     //     map.get(key).add(s);
        //     //     continue;
        //     //     // map.put(key, list);
        //     // }

        //     // //if the key doesn't exist in the map, add to teh new lsit and add that list to the map.
        //     // list.add(s);
        //     // map.put(key,list);

        // }

        // if(map.size() == 0) return res;

        // for(List<String> l: map.values()) res.add(l);

        // return res;

        // SOLUTION 2: (better way)

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

    // SOLUTION 3:

    // public List<List<String>> groupAnagrams(String[] strs) {
    //     Map<String, List<String>> res = new HashMap<>();

    //     for (String s : strs) {
    //         int[] count = new int[26];

    //         for (char c : s.toCharArray()) {
    //             count[c - 'a']++;
    //         }

    //         StringBuilder sb = new StringBuilder();
    //         for (int i = 0; i < 26; i++) {
    //             sb.append('#');
    //             sb.append(count[i]);
    //         }
    //         String key = sb.toString();
            
    //         if (!res.containsKey(key)) {
    //             res.put(key, new ArrayList<>());
    //         }
    //         res.get(key).add(s);
    //     }

    //     return new ArrayList<>(res.values());
    // }
}