class Solution {
    int n,m;
    public boolean dfs(int i , int j, int k ,char[][] board, String word, boolean[][] vis){
        // falining cases : Out of bound,  Already visited ,Character doesn't match
        if(i<0 || j<0 || i>=n || j>=m || board[i][j] != word.charAt(k) || vis[i][j]) 
            return false;

        if(k==word.length()-1 ) return true; //last character
        vis[i][j]=true;

        int[][] direct={ {0,1},{0,-1},{-1,0},{1,0}};
        for(int[] d:direct){
            int x= i+d[0];
            int y= j+d[1];

            if(dfs(x,y,k+1, board,word,vis)==true){
                 vis[i][j]=false;
                 return true;
            }
        }
        vis[i][j]=false; //backtrack
        return false;
    }
    public boolean exist(char[][] board, String word) {
        n= board.length;
        m=board[0].length;

        boolean[][] vis= new boolean[n][m];
        
        int k=0;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i,j,k,board,word,vis)) return true;
                }
            }
        }
        return false;
    }
}