class Solution {
    class Pair{
        int r;
        int c;
        Pair(int r , int c){
            this.r=r;
            this.c=c;
        }
    }
    public int minimumObstacles(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dist= new int[n][m];
        for(int i =0;i<n;i++){
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        Deque<Pair> dq= new ArrayDeque<>();
        dist[0][0]=0;
        dq.addFirst(new Pair(0,0));
        int[][] dir= {{-1,0},{1,0},{0,-1},{0,1}};
        while(!dq.isEmpty()){
            Pair p= dq.pollFirst();
            int r= p.r;
            int c= p.c;

            for(int[] d: dir){
                int nr= r+d[0];
                int nc= c+d[1];
                if(nr<0 || nr>=n || nc<0 || nc>=m){ //out of ranges
                    continue;
                }
                int distance= dist[r][c]+ grid[nr][nc]; 
                // curr dist+ new node dist(0/1)

                if(distance< dist[nr][nc]){ 
                    //if new is smaller then update
                    dist[nr][nc]=distance;

                    if(grid[nr][nc] == 0){
                        dq.addFirst(new Pair(nr, nc));
                    }else{
                        dq.addLast(new Pair(nr, nc));
                    }
                }
                
            }
        }

            
        return dist[n-1][m-1];
    }
}