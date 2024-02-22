class Solution {
    public int findJudge(int n, int[][] trust) {
       
        int[] trustsIn = new int[n + 1];
        int[] trustsOut = new int[n + 1];

      
        for (int[] relation : trust) {
            int a = relation[0];
            int b = relation[1];
            trustsOut[a]++;
            trustsIn[b]++;
        }

       
        for (int i = 1; i <= n; i++) {
            if (trustsOut[i] == 0 && trustsIn[i] == n - 1) {
                return i; 
            }
        }

        return -1; 
    }
}
