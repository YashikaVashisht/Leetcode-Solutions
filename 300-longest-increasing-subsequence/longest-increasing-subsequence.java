class Solution {
    int n;
    int dp[][];
    public int helper( int[] nums , int i , int prev_i){
        if(i == n) return 0;
        if(dp[i][prev_i +1] != -1) return dp[i][prev_i +1];
        //not PICK
        int l= helper(nums , i+1 , prev_i);
        if(prev_i == -1 || nums[i] > nums[prev_i]){ //PICK if prev_ind is -1( for 0th i case) and if curr> prev
            l= Math.max(l, 1+ helper(nums, i+1, i) );
        }

        return dp[i][prev_i + 1] = l;
    }
    public int lengthOfLIS(int[] nums) {
        n= nums.length;
        dp= new int[n][n+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return helper(nums , 0, -1); //starting prev_ind wiht -1 
    }
}