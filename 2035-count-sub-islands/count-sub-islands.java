class Solution {
    int n,m;
    public boolean bfs(int i , int j ,int[][] grid1, int[][] grid2, boolean[][] vis){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{i,j});
        vis[i][j]=true;
        int[][] direct = {
            {0, 1}, {0, -1}, {-1, 0}, {1, 0}
        };

        boolean valid=true;
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x= curr[0];
            int y= curr[1];

            if(grid1[x][y]==0) valid=false;

            for(int[] d: direct){
                int nx= x+d[0];
                int ny= y+d[1];

                if(nx>=0 && nx<n && ny>=0 && ny<m && grid2[nx][ny]==1 && !vis[nx][ny]){
                    vis[nx][ny]= true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
        return valid;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        n= grid1.length;
        m=grid1[0].length;

        boolean[][] vis = new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j]==1 && !vis[i][j]){
                    if(bfs(i,j,grid1,grid2,vis)==true) count++;
                }
            }
        }
        return count;
    }
}