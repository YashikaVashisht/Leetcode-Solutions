class Solution {
    public boolean helper(int  i , int[] nums, int tar,  Boolean[][] dp){
        if(tar==0) return true;
        if(i==0) return tar==nums[0];

        if(dp[i][tar] != null) return dp[i][tar];

        boolean pick=false;
        if(tar>= nums[i]){
            pick= helper(i-1, nums, tar-nums[i], dp);
        }
        boolean notpick= helper(i-1, nums, tar, dp);

        return dp[i][tar]= pick || notpick;
    }
    public boolean canPartition(int[] nums) {
        int n= nums.length;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }

        Boolean[][] dp = new Boolean[n][sum/2 +1];

        if(sum%2 != 0) return false;
        return helper(n-1, nums,sum/2, dp);
    }
}