class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n%k!=0) return false;
        HashMap<Integer, Integer> hm = new HashMap<>();
        Arrays.sort(nums);
        for(int num: nums){
            hm.put(num, hm.getOrDefault(num , 0)+1);
        }
        for(int num:nums){
            if(hm.get(num)==0) continue;

            for(int i=0;i<k;i++){
                int x= num+i;
                if(hm.getOrDefault(x, 0) == 0)
                    return false;
                hm.put(x, hm.get(x) - 1);    
            }
        }

        return true;

    }
}