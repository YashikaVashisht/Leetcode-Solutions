class Solution {
    public int minMaxGame(int[] nums) {
        int len=nums.length;
        while(len>1){
            int[] arr= new int[len/2];
            for (int i = 0; i < len; i += 2) {
                if ((i/2) % 2 == 0) {
                    arr[i/2] = Math.min(nums[i], nums[i + 1]); 
                } else {
                    arr[i/2] = Math.max(nums[i], nums[i + 1]); 
                }
            
            }
            nums=arr;
            len=len/2;
        }
        return nums[0];
    }
}