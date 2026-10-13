class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n= nums.length;
        int left=0;
        int right= n-1;
        boolean add=true;
        for(int i=0;i<n;i++){
            nums[i]= nums[i]*nums[i];
        }
        Arrays.sort(nums);
        long res=0;
        while(left<=right){
            if(add==false){
                res-=nums[left++];
            }else{
                res+=nums[right--];
            }

            add=!add;
        }
        return res;
    }
}