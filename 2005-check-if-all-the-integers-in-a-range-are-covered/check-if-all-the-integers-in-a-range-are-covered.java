class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int n= ranges.length;

        boolean[] vis= new boolean[right-left+1];
        Arrays.fill(vis, false);
        for(int i=0;i<n;i++){
            // if(ranges[i][0] >= left || ranges[i][1]<= right){
            //     vis[i]=true;
            // }
            for(int j=left; j<=right;j++) {
                if(j>=ranges[i][0] && j<=ranges[i][1]) {
                    vis[j-left] = true;
                }
            }
        }
        for(boolean v: vis){
            if(v==false) return false;
        }
        return true;
    }
}