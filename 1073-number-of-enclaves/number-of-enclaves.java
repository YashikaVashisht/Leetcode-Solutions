class Solution {
     public void dfs(int[][] grid,int[][] vis, int x ,int y ){
        int n= grid.length;
        int m= grid[0].length;
        int[] dx={-1, 1, 0, 0};
        int[] dy={0, 0, -1, 1};;
        vis[x][y]=1;

        for(int i=0;i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 1 && vis[nx][ny] == 0) {
                dfs(grid, vis, nx, ny);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];

        // DFS from all boundary cells that are 1s
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0) dfs(grid, vis, i, 0);
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0) dfs(grid, vis, i, m - 1);
        }

        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 1 && vis[0][j] == 0) dfs(grid, vis, 0, j);
            if (grid[n - 1][j] == 1 && vis[n - 1][j] == 0) dfs(grid, vis, n - 1, j);
        }

        // Count remaining land cells not connected to boundary
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}