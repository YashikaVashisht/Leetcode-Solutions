class Solution {
    public int pivotIndex(int[] nums) {
        // int pivot=0;
        // int n= nums.length;
        // for(int i=1;i<n-1;i++){
        //     int left=0;
        //     for(int l=0;l<i;l++){
        //         left+=nums[l];
        //     }
        //     int right=0;
        //     for(int r=i+1;r<n;r++){
        //         right+=nums[r];
        //     }
        //     if(left==right){
        //         return i;
        //     }
        // }
        // return -1;
        int n= nums.length;
        int total=0;
        for(int num: nums){
            total+= num;
        }
        int left=0;

        for(int i=0;i<n;i++){
            int right= total - left - nums[i];
            if(left==right) return i;
            
            left+=nums[i];
        }
        return -1;

    }
}