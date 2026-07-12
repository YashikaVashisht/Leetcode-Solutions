class Solution {
    
    public int helper(int i , int j , int n ,int[][] mat, int[][] dp){
        if(j<0 || j > n-1) return (int)1e9;
        if(i==n-1) return  mat[i][j];
        if(dp[i][j] != Integer.MAX_VALUE) return dp[i][j];
        int left= mat[i][j] + helper(i+1, j-1, n , mat, dp);
        int right= mat[i][j] + helper(i+1, j+1, n , mat,dp);
        int down= mat[i][j] + helper(i+1, j, n , mat, dp);

        return dp[i][j] = Math.min(down, Math.min(right, left));
    }
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix[0].length;
        // int m= matrix.length;
        int[][] dp= new int[n][n];
        for(int[] r: dp){
            Arrays.fill(r, Integer.MAX_VALUE);
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<n;j++){
            mini= Math.min(mini, helper(0, j , n , matrix, dp));
        }
        return mini;
    }
}