class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int n= grid.length;
        int m= grid[0].length;

        boolean[][] vis= new boolean[n][m];
        for(boolean[] row: vis){
            Arrays.fill(row, false);
        }

        for(int[] row: grid){
            Arrays.sort(row); 
            for (int i = 0, j = row.length - 1; i < j; i++, j--) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
            }
        }

        int ans=0;
        for(int i=0;i<m;i++){
            int maxi=0;
            for(int j=0;j<n;j++){
                maxi=Math.max(maxi, grid[j][i]);
            }
            ans += maxi;
        }
        return ans;
    }
}