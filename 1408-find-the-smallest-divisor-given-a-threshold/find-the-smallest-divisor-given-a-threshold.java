class Solution {
    public int helper(int[] nums, int d){
        int sum=0;
        for(int num:nums){
            sum+= (num+d-1)/d;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int n= nums.length;
        int low=1;
        int maxi=-1;
        for(int num: nums){
            maxi= Math.max(maxi,num);
        }

        int high= maxi;
        int ans= maxi;
        while(low<=high){
            int mid=(low+high)/2;
            int currSum= helper(nums, mid);

            if(currSum<= threshold){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}