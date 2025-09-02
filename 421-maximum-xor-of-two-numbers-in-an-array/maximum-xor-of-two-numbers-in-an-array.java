class Solution {

    public int findMaximumXOR(int[] nums) {
        int m=0; 
        int ans=0;
        for(int i=31;i>=0;i--){
            m=m | (1<<i);
            HashSet<Integer> set= new HashSet<>();
            for(int num: nums){
                set.add(num & m);
            }
            int temp=ans| (1<<i);
            for(int it: set){
                if(set.contains(it^ temp)){
                    ans=temp;
                }
            }
        }
        return ans;
    }
}