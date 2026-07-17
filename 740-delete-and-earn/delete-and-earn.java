class Solution {
    int n;
    public int collect(int[] nums, int i){ // to find sum of. all same elements if taken 
        int sum=0;
        int curr= nums[i];
        while (i<n && nums[i]==curr) {
            sum+=nums[i];
            i++;
        }
        return sum;
    }
    public int nextUnique(int[] nums, int i) { // to find the next unique element
        int curr = nums[i];

        while (i < n && nums[i] == curr)
            i++;

        return i;
    }
    public int findNext(int[] nums, int i){ 
    // to.  find next elements  not euqal to curr, curr+1 
        int curr= nums[i];
        i = nextUnique(nums, i); // Skip current value
        while (i < n && nums[i] == curr + 1)
            i++;

        return i;
    }
    public int helper(int[] nums, int i, int[] dp){
        if(i>=n) return 0;
        if(dp[i] != -1) return dp[i];
        int nextith= findNext(nums, i);

        int pick=  collect(nums, i) + helper(nums, nextith , dp);
        int nopick= helper(nums, i+1,  dp);
        return dp[i]= Math.max(pick,nopick);
    }
    public int deleteAndEarn(int[] nums) {
        Arrays.sort(nums);
        n= nums.length;
        int[] dp= new int[n+1];
        Arrays.fill(dp ,-1);
        return helper(nums,0, dp);
    }
}