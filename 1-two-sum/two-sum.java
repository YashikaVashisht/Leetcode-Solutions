class Solution {
    public int[] twoSum(int[] nums, int target) {
        int res[]=new int[2];
        HashMap<Integer, Integer> m=new HashMap<>();
        for(int i=0;i<nums.length;i++){
                if( m.containsKey(target-nums[i])){
                    int value=m.get(target-nums[i]);   
                        res[0]=value;
                        res[1]=i;
                    
                }else{
                    m.put(nums[i],i);
                }
            
            
        }
        System.out.println(m);
        return res;
    }
}