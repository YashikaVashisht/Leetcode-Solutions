class Solution {

    public int getNext(int[][] arr, int l, int currEnd, int n){
        int r= n-1;
        int res= n+1;
        while(l<=r){
            int mid= (l+r)/2;
            if(arr[mid][0] >= currEnd){ //newstart > currend
                res= mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }

    public int helper(int[][] arr, int i, int n , int[] dp){
        if(i>=n) return 0;
        if(dp[i] != -1) return dp[i];
        int next= getNext(arr,i+1, arr[i][1], n); 
        // finding next startime > curr endtime

        int taken=arr[i][2] + helper(arr, next, n, dp);
        int notTaken=  helper(arr, i+1, n, dp);

        return dp[i]=Math.max(taken, notTaken);

    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n= startTime.length;
        int[][] arr= new int[n][3];  //{s,e,p}
        for(int i =0;i<n;i++){
            arr[i][0]=startTime[i];
            arr[i][1]=endTime[i];
            arr[i][2]=profit[i];
        }
        //sort by starttime
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        return helper(arr, 0, n, dp);
        
    }
}