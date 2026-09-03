class Solution {
    public int islandPerimeter(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        int peri=0;
        int[][] direct= {
            {0,-1},{0,1},{-1,0},{1,0}
        };
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                     for (int[] d : direct) {
                        int nx=i+d[0];
                        int ny= j+d[1];

                        // Outside OR water = exposed side
                        if (nx<0||ny<0 ||
                            nx>=n || ny>=m ||
                            grid[nx][ny] == 0) {

                            peri++;
                        }
                    }
                }
            }
        }
        return peri;
    }
}