class Solution {
    public int search(int[] nums, int target) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], i);
        } 

        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(nums[i]== target){
                return hm.get(nums[i]);
            }
        }
        return -1;
    }
}