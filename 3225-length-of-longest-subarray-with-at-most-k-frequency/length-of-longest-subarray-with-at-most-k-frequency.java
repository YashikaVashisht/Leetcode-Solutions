class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n= nums.length;
        int i=0;
        int j=0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        int res=0;
        while(j<n){
            hm.put(nums[j], hm.getOrDefault(nums[j], 0) + 1);

            while(i<n && hm.get(nums[j]) >k){ //shrink
                hm.put(nums[i], hm.get(nums[i])-1);
                i++;
            }
            res=Math.max(res, j-i+1);
            j++;
        }
        return res;
    }
}