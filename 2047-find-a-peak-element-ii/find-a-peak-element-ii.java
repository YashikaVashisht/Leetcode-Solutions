class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n= mat.length; // no of rows
        int m= mat[0].length; // no of cols

        
        for(int col=0; col<m;col++){
            int maxi=0; ///rowth
            for(int r=0;r<n;r++){
                if(mat[r][col]> mat[maxi][col]){
                    maxi=r;
                }
            }

            boolean isPeak=true;

            if(col>0 && mat[maxi][col-1]>mat[maxi][col]) {
                isPeak=false;
            }
            if(col<m-1 && mat[maxi][col+1] > mat[maxi][col]) {
                isPeak=false;
            }

            if(isPeak){
                return new int[]{maxi,col};
            }
        }
        return new int[]{-1,-1};
    } 
}