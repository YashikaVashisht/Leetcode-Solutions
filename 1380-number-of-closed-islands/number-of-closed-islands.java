class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    int n,m;

    public void bfs(int i , int j,int[][] grid, boolean[][] vis ){
        Queue<Pair> q= new LinkedList<>();
        q.offer(new Pair(i,j));
        vis[i][j]=true;

        int[][] direct = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        while(!q.isEmpty()){
            Pair p= q.poll();
            int x=p.x;
            int y=p.y;
            for(int[] d: direct){
                int nx= d[0]+x;
                int ny= d[1]+y;

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    grid[nx][ny] == 0 &&
                    !vis[nx][ny]) {

                    vis[nx][ny] = true;
                    q.offer(new Pair(nx,ny));
                }
            }
        }
    }
    public int closedIsland(int[][] grid) {
        n= grid.length;
        m = grid[0].length;

        boolean[][] vis= new boolean[n][m];
        
        for(int j=0;j<m;j++){
            if(grid[0][j]==0 && !vis[0][j]){ //for 0th row
                bfs(0, j, grid, vis);
            }

            if(grid[n-1][j]==0 && !vis[n-1][j]){
                //for last row
                bfs(n-1, j, grid, vis);
            }
        }

        for(int i=0;i<n;i++){
            if(grid[i][0]==0 && !vis[i][0]){ // 0th col
                bfs(i, 0, grid, vis); 
            }
            if(grid[i][m-1]==0 && !vis[i][m-1]){ // last col
                bfs(i, m-1, grid, vis); 
            }
        }


        //counting for islands by leaving the 0th and last row & cols
        int count=0;
        for(int i=1;i<n-1;i++){ 
            for(int j=1;j<m-1;j++){
                if(grid[i][j]==0 && !vis[i][j] ){
                    count++;
                    bfs(i,j,grid, vis);
                }
            }
        }
        return count;
    }
}