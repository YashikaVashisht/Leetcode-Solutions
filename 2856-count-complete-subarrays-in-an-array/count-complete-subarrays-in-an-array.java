class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n= nums.length;
        HashMap<Integer, Integer> hm= new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int unique=set.size();
        int i=0;
        int j=0;
        int res=0; 
        while(j<n){
            hm.put(nums[j], hm.getOrDefault(nums[j],0)+1 ) ;
            while(hm.size()==unique){
                res+=(n-j);
                hm.put(nums[i], hm.get(nums[i]) - 1);
                if(hm.get(nums[i])==0){
                    hm.remove(nums[i]);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}