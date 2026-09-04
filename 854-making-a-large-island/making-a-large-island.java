class Solution {
    int n;
    int m;
    public int bfs(int i , int j, int[][] grid, int id){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{i,j});
        grid[i][j]=id;
        int area=0;
        int[][] direct = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int x= curr[0];
            int y= curr[1];
            area++;
            for (int[] d : direct) {
                int nx = x + d[0];
                int ny = y + d[1];

                if (nx >= 0 && nx < n &&
                    ny >= 0 && ny < m &&
                    grid[nx][ny] == 1) {

                    grid[nx][ny] = id;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return area;

    } 
    public int largestIsland(int[][] grid) {
        n= grid.length;
        m= grid[0].length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        //labeliing each Island 
        int maxi=0;
        int id=2;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 ){
                    int area= bfs(i,j,grid, id);
                    hm.put(id, area);
                    maxi=Math.max(maxi,area);
                    id++;
                }
            }
        }
        // check every 0
        int[][] direct = {
            {-1, 0}, {1, 0}, {0, -1}, {0, 1}
        };

         for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0 ){ //finding the water
                    int area=1;

                    HashSet<Integer> set= new HashSet<>();
                    for (int[] d : direct) {
                        int nx=i+d[0];
                        int ny=j+d[1];

                        if (nx >= 0 && nx < n &&
                            ny >= 0 && ny < m &&
                            grid[nx][ny] != 0) {
                            set.add(grid[nx][ny]); //adding the surrounded island in the set 
                        }
                    }

                    for(int s:set){
                        area+=hm.get(s);
                    }
                    maxi = Math.max(maxi, area);
                }
            }
        }     
        return maxi;   

    }
}