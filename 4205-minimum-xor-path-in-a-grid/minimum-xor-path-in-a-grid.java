class Solution {
    boolean[][][] vis;
    int ans;
    int m,n;

    public void helper(int i, int j, int prev, int[][] grid) {
        int curr=prev^grid[i][j];

        if(vis[i][j][curr]) return;
        vis[i][j][curr]=true;

        if(i==m-1 && j==n-1){
            ans=Math.min(ans,curr);
            return;
        }

        if(ans==0) return;

        if(j+1<n){
            helper(i,j+1,curr,grid);
        }

        if(i+1<m){
            helper(i+1,j,curr,grid);
        }
    }

    public int minCost(int[][] grid) {
        m=grid.length;
        n=grid[0].length;

        vis=new boolean[m][n][1024];
        ans=Integer.MAX_VALUE;

        helper(0,0,0,grid);

        return ans;
    }
}