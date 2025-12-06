class Solution {
    public int countPartitions(int[] nums) {
        int n=nums.length;
        int i=1;
        int count=0;
        while(i<n){
            int left=0;
            int right=0;
            for(int j=0;j<i;j++){
                left+=nums[j];
            }
            for(int j=i;j<n;j++){
                right+=nums[j];
            }
            int diff=right-left;
            System.out.println(diff);
            if((diff)%2==0){
                count++;
            }
            i++;
        }
        return count;
    }
}