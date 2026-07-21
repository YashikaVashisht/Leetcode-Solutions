class Solution {
    int[][] dp ;
    public int helper(int[] nums1, int[] nums2, int i , int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];

        if(nums1[i]== nums2[j]) return dp[i][j]= 1+ helper(nums1, nums2, i-1,j-1);
        else{
            return dp[i][j]= 0+ Math.max( helper(nums1, nums2, i-1,j),helper(nums1, nums2, i,j-1) ); 
        }
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int m= nums1.length;
        int n= nums2.length;
        dp = new int[m][n];
        for(int[] r: dp){
            Arrays.fill(r, -1);
        }
        return helper(nums1, nums2, m-1, n-1);
    }
}