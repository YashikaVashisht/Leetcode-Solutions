class Solution {
    public int maxScore(int[] arr ,int k) {
        int n=arr.length;
        int lsum=0;
        int rsum=0;
        int maxSum=0;
        for(int i=0; i<k; i++){
            lsum+=arr[i];
        }
        maxSum=lsum;

        int rIndx=n-1;
        for(int i=k-1; i>=0; i--){
            lsum-=arr[i];
            rsum= rsum+ arr[rIndx];
            rIndx--;
            maxSum=Math.max(maxSum, lsum+rsum);
        }
        return maxSum;

        
    }
}