class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n=nums.length;
        int res= Integer.MAX_VALUE;
        int i=0;
        int j=0;
        int sum=0;
        while(j<n){
            sum+=nums[j];
            //window shrinking from left side 
            while(sum>=target){
                res= Math.min(res,j-i+1);
                sum-= nums[i];
                i++;   
            }
            j++;
        }
        if(res==Integer.MAX_VALUE) return 0;
        else return res;
    }
}