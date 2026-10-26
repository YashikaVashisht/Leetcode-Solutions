class Solution {
    class Pair {
        int r;
        int c;

        Pair(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int countIslands(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]>0){
                    Queue<Pair> q = new LinkedList<>();
                    q.add(new Pair(i,j));

                    long sum = grid[i][j];
                    grid[i][j] = 0;

                    while(!q.isEmpty()){
                        Pair p = q.poll();
                        int r = p.r;
                        int c = p.c;

                        for(int d=0;d<4;d++){
                            int nr = r + dir[d][0];
                            int nc = c + dir[d][1];

                            if(nr>=0 && nr<m && nc>=0 && nc<n
                                && grid[nr][nc]>0){

                                sum += grid[nr][nc];
                                grid[nr][nc] = 0;
                                q.add(new Pair(nr,nc));
                            }
                        }
                    }

                    if(sum%k==0){
                        ans++;
                    }
                }
            }
        }

        return ans;
    }
}