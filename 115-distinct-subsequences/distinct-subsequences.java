class Solution {
    public int helper(String s, int i, String t, int j, int[][] dp ){
        if(j<0 ) return 1;  // t is tranversed fully, means found in s.
        if(i<0 ) return 0;  // s i finsihdbut NOT FOUND yet.

        if(dp[i][j]!= -1) return dp[i][j];

        if(s.charAt(i)==t.charAt(j)){
           return dp[i][j]= helper(s,i-1,t,j-1, dp) + helper(s,i-1,t,j ,dp);
        }else{
            return dp[i][j]= helper(s,i-1,t,j, dp);
        }
    }
    public int numDistinct(String s, String t) {
        int n= s.length();
        int m= t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(s, n-1, t, m-1 ,dp);
    }
}