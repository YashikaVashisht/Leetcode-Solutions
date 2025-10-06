class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {

        int m = board.length;
        int n = board[0].length;
        int r= click[0];
        int c= click[1];

        if(board[r][c]=='M') {
            board[r][c]='X';
            return board;
        }

        int[][] directions= {{1,0}, {-1,0}, {0,1}, {0,-1},
            {1,1}, {1,-1}, {-1,1}, {-1,-1}
        };
        Queue<int[]> q= new LinkedList<>();
        q.add(new int[]{r,c});

        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x= curr[0];
            int y= curr[1];

            if(board[x][y] != 'E') continue;

            int mines=0;
            for(int[] d: directions){
                int newX= x+d[0];
                int newY= y+d[1];
                if(newX >= 0 && newX< m && newY>=0 && newY<n && board[newX][newY] =='M'){
                    mines++;
                }
            }
            if(mines>=1){
                board[x][y]=(char)(mines+'0');
            }else{
                board[x][y]='B';
                for(int[] d: directions){
                    int newX= x+d[0];
                    int newY= y+d[1];
                    if(newX >= 0 && newX< m && newY>=0 && newY<n && board[newX][newY] =='E'){
                        q.add(new int[]{newX, newY});
                    }
                }

            }
            

        }
        return board;

    }
}