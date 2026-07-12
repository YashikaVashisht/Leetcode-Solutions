class Solution {
    public int helper(int i , int j,  int[][] dp, int[][] grid){
        if(i==0 && j==0) return 1;
        if(i<0 ||j <0) return 0;
        
        if(grid[i][j]==1) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int left= helper(i,j-1, dp , grid);
        int up= helper(i-1,j, dp , grid);
        return dp[i][j]= up+left;
    }
    public int uniquePathsWithObstacles(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;
        if(grid[0][0] ==1) return 0; //means starting is obsactle already , so no path is possbile 
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row,-1);
         }
        return helper(n-1,m-1,dp,grid);

    }
}