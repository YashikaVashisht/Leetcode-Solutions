class Solution {
    int[][] dp ;
    public int helper(String s, String t, int i , int j){
        if(i< 0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j]= 1+ helper(s, t, i-1,j-1);
        }else{
            return dp[i][j]=Math.max( helper(s,t,i-1,j) ,helper(s,t,i,j-1) );
        }
    }
    
    public int longestPalindromeSubseq(String s) {
        int n= s.length();
        String t= new StringBuilder(s).reverse().toString();

        dp = new int[n][n];
        for(int[] r: dp) Arrays.fill(r, -1);

        //finnd find out the longest common subseqqnce of s and t 
        return helper(s,t, n-1, n-1);
    }
}