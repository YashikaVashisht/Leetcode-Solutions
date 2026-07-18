class Solution {
    public int helper(int n, int[] dp){
        if(n==1) return 1;
        if(dp[n] != -1) return dp[n];
        int res=0;
        for(int i=1;i<n;i++){
            int prod= i* (Math.max(n-i, helper(n-i, dp)) );
            res= Math.max(res,prod);
        }
        return  dp[n]= res;
    }
    public int integerBreak(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return helper(n, dp);
    }
}