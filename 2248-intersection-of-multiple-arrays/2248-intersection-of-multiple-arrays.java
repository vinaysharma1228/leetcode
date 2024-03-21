class Solution {
    public List<Integer> intersection(int[][] nums) {
        int freq[]=new int[1001];
        ArrayList<Integer> a=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums[i].length;j++){
              freq[nums[i][j]]++;
            }
           
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]==nums.length){
                a.add(i);
            }
        }
        return a;
    }}