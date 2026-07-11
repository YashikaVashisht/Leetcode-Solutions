class Solution {
    public int helper(int[] arr, int n, int i , int d, int[][] dp){
        if(d==1){ // if 1 day left , so will find maxi from the remianing tasks
            int maxD= arr[i];
            for( int j = i; j<n;j++){
                maxD= Math.max(maxD, arr[j]);
            }
            return maxD;
        }
        if(dp[i][d] != -1) return dp[i][d];
        int maxD= arr[i];
        int res= Integer.MAX_VALUE;
        //now try one by one with all possibility
        for( int j = i; j <= n - d; j++){
                maxD= Math.max(maxD, arr[j]);
                int temp= maxD+ helper(arr, n, j+1, d-1, dp);
                res= Math.min(res, temp);
        }
        return dp[i][d]=res;

    }
    public int minDifficulty(int[] jobDifficulty, int d) {
       
        int n= jobDifficulty.length;      
        if(d>n) return -1;
        int[][] dp = new int[n][d+1];
        for(int[] row: dp){
            Arrays.fill(row,-1);
        }
        return helper(jobDifficulty, n, 0, d, dp);
    }
}