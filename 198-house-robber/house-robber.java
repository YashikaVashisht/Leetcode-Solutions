class Solution {
     public int helper(int[] arr, int sum, int i,  int[] dp){
        if (i < 0) return 0; 
        if (i == 0) return arr[0]; 
        
        if (dp[i] != -1) return dp[i];
        int pick = arr[i]+ helper(arr, sum, i-2, dp);

        
        int notpick = helper(arr, sum , i-1, dp);
        return dp[i]= Math.max(pick, notpick);
    }
    public int rob(int[] arr) {
        
         int n = arr.length;
        int sum=0;
        
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return helper(arr, sum, n-1, dp);
        
    }
}