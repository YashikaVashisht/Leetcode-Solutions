class Solution {
    public int findFinalValue(int[] nums, int original) {
        HashSet<Integer> set=new HashSet<>();
        for(int num:nums){
            set.add(num);
        }

        boolean found=true;
        while(found){
            if(set.contains(original)){
                original*=2;
            }else{
                found=false;
                break;
            }

        }
        return original;
    }
}