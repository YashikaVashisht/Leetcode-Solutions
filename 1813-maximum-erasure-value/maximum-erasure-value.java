class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int n= nums.length;
        int i=0;
        int j=0;
        int sum=0;
        int res=0;
        while(j<n){
            if(!hm.containsKey(nums[j])){
                sum+=nums[j];
                res=Math.max(res, sum);
                hm.put(nums[j],1);
                j++;
            }else{
                while (hm.containsKey(nums[j])) {
                    sum -= nums[i];
                    hm.remove(nums[i]);
                    i++;
                }
            }
        }
        return res;
    }
}