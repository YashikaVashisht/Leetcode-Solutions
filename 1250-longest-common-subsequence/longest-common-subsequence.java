class Solution {
    int[][] dp;
    public int helper(String s1, String s2, int i , int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j]=1+ helper(s1, s2, i-1, j-1);
        }
        else{
            return  dp[i][j]= 0+ Math.max( helper(s1,s2,i-1,j), helper(s1,s2,i,j-1) );
        }    
    }
    public int longestCommonSubsequence(String s1, String s2) {
        int m= s1.length();
        int n= s2.length();
        dp = new int[m][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(s1,s2, m-1, n-1);
    }
}