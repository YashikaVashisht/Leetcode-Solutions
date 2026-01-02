class Solution {
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        for(int num:nums){
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            }else{
                hm.put(num,1);
            }
        }
         for (int key : hm.keySet()) {
            if (hm.get(key) > 1) {
                return key;
            }
        }

        return -1;

    }
}