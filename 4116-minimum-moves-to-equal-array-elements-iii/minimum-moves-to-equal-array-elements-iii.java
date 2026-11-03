class Solution {
    public int minMoves(int[] nums) {
        int count=0;
        int maxi=-1;
        for(int num: nums){
            maxi=Math.max(maxi, num);
        }   
        for(int num: nums){
            if(num<maxi){
                count+=maxi-num;
            }
        }
        return count;
    }
}