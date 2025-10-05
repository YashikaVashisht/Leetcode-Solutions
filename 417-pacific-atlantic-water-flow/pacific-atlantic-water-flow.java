class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private void dfs(int[][] heights, boolean[][] reachable, int r, int c) {
        if(reachable[r][c]) return;
        reachable[r][c] = true;
        
        for(int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if(nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length
               && heights[nr][nc] >= heights[r][c]) {
                dfs(heights, reachable, nr, nc);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific - top row
        for(int j=0;j<n;j++){
            dfs(heights, pacific, 0, j);
        }
        // Pacific - left column
        for(int i=0;i<m;i++){
            dfs(heights, pacific, i, 0);
        }

        // Atlantic - bottom row
        for(int j=0;j<n;j++){
            dfs(heights, atlantic, m-1, j);
        }
        // Atlantic - right column
        for(int i=0;i<m;i++){
            dfs(heights, atlantic, i, n-1);
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }
        return result;
    }
}