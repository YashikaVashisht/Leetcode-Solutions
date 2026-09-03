class Solution {
    public int orangesRotting(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        int fresh=0;
        Queue<int[]> q= new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==2){
                    q.offer(new int[]{i,j});
                }
                if(grid[i][j]==1) fresh++;
            }
        }

        if(fresh==0) return 0;
        int time=0;
        int direct[][]= {{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty() && fresh>0){
            int k = q.size();
            for(int i=0;i<k;i++){
                int[] curr= q.poll();
                int x= curr[0];
                int y= curr[1];

                for(int[] d: direct){
                    int nx= x+d[0];
                    int ny= y+d[1];

                    if(nx>=0 && nx<n && ny>=0 && ny<m && grid[nx][ny]==1){
                        grid[nx][ny]=2;
                        q.offer(new int[]{nx,ny});
                        fresh--;
                    }
                }
            
            }
            time++;
            
        }
        if(fresh==0) return time;
        return -1;


    }
}