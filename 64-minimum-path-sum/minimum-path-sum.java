class Solution {
   public int helper(int i , int j, int[][] grid, int n , int m,  int[][] dp ){
   if(i >= n || j >= m) return (int)1e9;
    if(i==n-1 && j==m-1) return  grid[n-1][m-1];
    if(dp[i][j] != -1) return dp[i][j];
    int down= grid[i][j]+ helper(i+1, j, grid,n,m,dp);
    int right= grid[i][j]+ helper(i, j+1, grid,n,m,dp);
    return dp[i][j]=Math.min(down , right);
   }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(0,0, grid, n , m, dp);
    }
}