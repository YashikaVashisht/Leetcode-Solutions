class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n= grid.length;
        // int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

        Queue<int[]> q= new LinkedList<>();
        boolean[][] vis = new boolean[n][n];

        q.offer(new int[]{0,0,1});
        vis[0][0]=true;

        int[][] direct={
            {-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}
        };
        while(!q.isEmpty()){
            int[] curr= q.poll();
            int i=curr[0];
            int j= curr[1];
            int dist = curr[2];
            if (i == n-1 && j == n-1) return dist;

            for(int[] d: direct){
                int ni= i+d[0];
                int nj= j+d[1];
                if(ni>=0 && nj>=0 && ni<n && nj<n && !vis[ni][nj] && grid[ni][nj]==0){
                    vis[ni][nj] = true;
                    q.add(new int[]{ni, nj, dist + 1});
                }
            }

        
        }

        return -1;

    }
}