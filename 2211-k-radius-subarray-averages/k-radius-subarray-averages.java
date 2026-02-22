class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] res= new int[n];
        Arrays.fill(res,-1);



        int left= 0;
        int windowSize= 2*k+1;

        if (windowSize > n) return res;  
        int right= windowSize;
        long sum=0;
        for(int l=0; l<windowSize ;l++){
            sum+= nums[l];
        }
        int mid= k;
        res[mid]= (int)(sum/windowSize);
        while(right<n){
            sum+=nums[right];
            sum-=nums[right-windowSize];
            mid++;
            res[mid]= (int)(sum/windowSize);
            right++;
        }
        return res;
    }
}