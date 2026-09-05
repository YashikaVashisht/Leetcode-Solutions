class Solution {
    int n;
    int m;
     public int dfs(int i , int j, int[][] grid,boolean[][] vis){
        if(i<0 || i>=n || j<0 || j>=m || grid[i][j]==0 || vis[i][j]) return 0;

        vis[i][j]=true;
        int[][] direct = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        int gold=0;
        for(int[] d: direct){
            int ni= i+d[0];
            int nj= j+d[1];
            gold= Math.max(gold, dfs(ni,nj ,grid,vis));
            
        }
        vis[i][j]=false; 
        //backtracking

        return grid[i][j]+ gold;

     }
    public int getMaximumGold(int[][] grid) {
        n=grid.length;
        m=grid[0].length;
        boolean[][] vis= new boolean[n][m];

        int maxi=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0){
                    maxi= Math.max(maxi, dfs(i,j,grid, vis));
                }
            }
        }
        return maxi;
    }
}