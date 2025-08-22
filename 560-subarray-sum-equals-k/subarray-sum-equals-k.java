class Solution {
    public int subarraySum(int[] nums, int k) {
        int count=0;
        for(int i=0;i<nums.length;i++){
            int start=i;
            int curr_sum=0;
            for(int j=i;j<nums.length;j++){
                curr_sum+=nums[j];
                if(curr_sum==k){
                    count++;
                    // break;
                }
            }
        }
        return count;
    }
}