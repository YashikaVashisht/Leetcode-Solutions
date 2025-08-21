class Solution {
    public static int helper(int i, int[] arr , int d , int sum , int [][] dp) {
        if(i==0){
            if(arr[i] ==0 && sum==0) return 2;
            if(arr[i]==sum || sum==0) return 1;
            return 0;
        }
        
        if(dp[i][sum] !=-1) return dp[i][sum];

        int notInclude= helper(i-1, arr,d, sum,dp);
        int include=0;
        if(arr[i]<= sum){
            include= helper(i-1, arr,d,  sum-arr[i],dp);
        }
        
        return dp[i][sum]= include+ notInclude;
    }

    public int findTargetSumWays(int[] arr, int d) {

        int n = arr.length;
        int totalSum=0;
        for(int it : arr){
            totalSum+=it;
        }

        if ((totalSum + d) % 2 != 0 || totalSum < d) return 0;
        int sum = (totalSum+Math.abs(d))/2;
        int[][] dp = new int [n][sum+1];
        for(int [] row: dp){
            Arrays.fill(row,-1);
        }
        
        return helper(n-1, arr, d,sum,dp);
        
        
    }
}