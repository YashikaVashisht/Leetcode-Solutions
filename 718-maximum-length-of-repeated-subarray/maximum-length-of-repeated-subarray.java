class Solution {
    int ans=0;
    int dp[][];
     public int helper(int[] nums1, int[] nums2 , int i , int j){
        if( i<0 || j<0) return 0;
        if (dp[i][j] != -1)  return dp[i][j];

        helper(nums1, nums2, i - 1, j);
        helper(nums1, nums2, i, j - 1);

        if(nums1[i] == nums2[j]) {
            dp[i][j]=1+helper(nums1, nums2, i-1, j-1);
            ans=Math.max(ans,dp[i][j]);
            
        }else {
            dp[i][j] = 0;
        }

        return dp[i][j];
     }
    public int findLength(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        dp= new int[m][n];
        for(int[] row:dp)
            Arrays.fill(row,-1);
        helper(nums1, nums2, m-1, n-1);
        return ans;
    }
}