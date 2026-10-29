class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k)-helper(nums,k-1);
    }

    public int helper(int[] nums, int k) {
        if(k<0) return 0;

        int l=0;
        int sum=0;
        int count=0;

        for(int r=0;r<nums.length;r++){
            sum+=nums[r]%2;

            while(sum>k){
                sum-=nums[l]%2;
                l++;
            }

            count+=r-l+1;
        }

        return count;
    }
}