class Solution {
    public int search(int[] nums, int target) {
        int n=nums.length;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], i);
        } 

        Arrays.sort(nums);
        // for(int i=0;i<nums.length;i++){
        //     if(nums[i]== target){
        //         return hm.get(nums[i]);
        //     }
        // }
        // return -1;
        int low=0;
        int high=n-1;
        while(low<=high){
            int mid=(low+high)/2;
            if(nums[mid]==target){
                return hm.get(nums[mid]);
            }else if(nums[mid]> target){
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return -1;
    }
}