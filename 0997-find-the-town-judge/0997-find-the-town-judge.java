class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] countTrusts = new int[n+1];
        for(int[] t : trust) {
            countTrusts[t[0]] = -1;
            if(countTrusts[t[1]] == -1) continue;
            countTrusts[t[1]]++;
        }
        for(int i=1; i <n+1; i++){
            if(countTrusts[i] == n-1) return i;
        }
        return -1;
    }
}