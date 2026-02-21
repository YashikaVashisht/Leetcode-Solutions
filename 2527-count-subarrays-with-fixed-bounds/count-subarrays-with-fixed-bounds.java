class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int minPos=-1;
        int maxPos=-1;
        int culpritInd=-1;
        long ans = 0;

        for(int i=0;i<nums.length ;i++){
            if(nums[i] < minK || nums[i] > maxK){  // out of range
                culpritInd=i;
            }
            if(nums[i] == minK){
                minPos = i;
            }

            if(nums[i] == maxK){
                maxPos = i;
            }


            long smaller= Math.min(maxPos, minPos);
            if(smaller > culpritInd){
                ans += (smaller - culpritInd);
            }
        }
        return ans;


    }
}