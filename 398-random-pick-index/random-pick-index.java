import java.util.*;
class Solution {
    HashMap<Integer, ArrayList<Integer>> hm;
     Random rand;
    public Solution(int[] nums) {
        hm= new HashMap<>();
        rand = new Random(); 
        for(int i=0;i<nums.length;i++){
            if(hm.containsKey(nums[i])){
                ArrayList<Integer> l= hm.get(nums[i]);
                l.add(i);

            }else{
                ArrayList<Integer> l = new ArrayList<>();
                l.add(i);
                hm.put(nums[i], l);
            }
        }
    }
    
    public int pick(int target) {
        ArrayList<Integer> list = hm.get(target);
        int randomIndex = rand.nextInt(list.size());
        return list.get(randomIndex);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */