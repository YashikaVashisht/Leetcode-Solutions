class Solution {
    public long countSubarrays(int[] nums, long k) {
        long res=0;
        int n=nums.length;
        int i=0;
        int j =0;
        long sum=0;
        while(j<n){
            sum+=nums[j];
            while(i<n && (sum*(j-i+1)) >= k){
                //shrink
                sum-=nums[i];
                i++;
            }
            res+=(j-i+1);
            j++;
        }
        return res;
    }
}