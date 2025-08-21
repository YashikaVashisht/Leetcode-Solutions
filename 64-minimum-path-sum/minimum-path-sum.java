class Solution {
     public static int helper(int i, int j, int[][] grid,  int[][] dp){
        if(i==0 && j==0) return grid[i][j];
        if (i<0 || j<0) return (int)1e9;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }

        int up= grid[i][j]+helper(i-1, j, grid, dp);
        int left= grid[i][j]+helper(i, j-1, grid, dp);
        return dp[i][j]= Math.min(up,left);
    }
    
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][] dp = new int [m][n];
        for(int[] i:dp){
            Arrays.fill(i,-1);
        }
        return helper(m-1,n-1,grid, dp);
        
//         for(int i=0;i<m;i++){
//             for(int j=0;j<n;j++){
//                 if(i==0 &&j==0){
//                     dp[i][j]=grid[i][j];
//                 }else if(i==0){
//                     dp[i][j]=dp[i][j - 1] + grid[i][j]; ;
//                 }else if(j==0){
//                     dp[i][j]=dp[i - 1][j] + grid[i][j];;
//                 }else{
//                     dp[i][j]=Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j]; 
//                 }
//             }
//         }
//         return dp[m - 1][n - 1];
    }
}