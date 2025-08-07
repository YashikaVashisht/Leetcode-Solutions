class Solution {
    public void dfs(char[][] board,int[][] vis, int x ,int y ){
        int n= board.length;
        int m= board[0].length;
        int[] dx={-1, 1, 0, 0};
        int[] dy={0, 0, -1, 1};;
        vis[x][y]=1;

        for(int i=0;i<4; i++){
            int nx=x+dx[i];
            int ny=y+dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && board[nx][ny] == 'O' && vis[nx][ny] == 0) {
                dfs(board, vis, nx, ny);
            }
        }
    }
    public void solve(char[][] board) {
        int n= board.length;
        int m= board[0].length;

        Queue<int[]> q= new LinkedList<>();
        int[][] vis=new int[n][m];
        for(int[] it:vis){
            Arrays.fill(it,0);
        }
        // boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(i!= 0 && i!=n-1 && j!=0 &&j!=m-1){
                    continue;
                }if(vis[i][j]==0 && board[i][j]=='O'){
                    dfs(board,vis,i,j);
                }
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
               if(vis[i][j]==0 && board[i][j]=='O'){
                    board[i][j]='X';
               }
            }
        }

        

    }
}