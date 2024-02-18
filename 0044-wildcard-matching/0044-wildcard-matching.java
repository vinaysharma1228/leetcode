

class Solution {
    boolean[] arr;
    public boolean isMatch(String s, String p) {
        arr = new boolean[p.length()+1];
        Arrays.fill(arr,true);
        boolean flag = true;
        for(int i=p.length()-1;i>=0;i--){
            if(p.charAt(i)!='*'){
                flag=false;
            }
            arr[i]=flag;
        }
        return solve(s,p,0,0,new Boolean[s.length()+1][p.length()]);
    }

    private boolean solve(String s,String t,int i,int j,Boolean[][] dp){
        if(i==s.length()){
            return arr[j];
        }
        if(j==t.length()){
            return i==s.length();
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        if(Character.isLowerCase(t.charAt(j)) && s.charAt(i)!=t.charAt(j)){
            return dp[i][j] = false;
        }
        if(t.charAt(j)=='*'){
            if(solve(s,t,i+1,j,dp)){
                return true;
            }
            if(solve(s,t,i,j+1,dp)){
                return true;
            }
        }
        return dp[i][j] = solve(s,t,i+1,j+1,dp)? true: false;
    }
}