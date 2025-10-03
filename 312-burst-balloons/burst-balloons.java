class Solution {
    
    public int helper(int[] nums, int i , int j, int[][] dp){
        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        int max= 0;
        for(int k=i;k<=j;k++){
            int cost= nums[i-1] * nums[k] * nums[j+1]
            + helper(nums,i,k-1, dp)+helper(nums, k+1, j, dp);
            max= Math.max(max, cost);
        }

        return dp[i][j]= max;
    }
    public int maxCoins(int[] arr) {
       
        int m = arr.length;
        int[] nums = new int[m + 2];

        nums[0] = 1; 
        for (int i = 0; i < m; i++) {
            nums[i + 1] = arr[i];
        }
        nums[m + 1] = 1;

        int[][] dp = new int[m + 2][m + 2];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return helper(nums, 1, m, dp);


    }
}