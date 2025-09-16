class Solution {
    public boolean ifPossible(int[] arr, int day, int k, int m){
        int poss=0;
        int counter=0;
        for(int a:arr){
           if (a <= day) {
                counter++;
                if(counter == k) {
                    poss++;
                    counter = 0;
                }
            } else {
                counter = 0;
            }
        }
        if(poss>=m){
            return true;
        }else{
            return false;
        }
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int mini=Integer.MAX_VALUE;
        int maxi=-1;
        for(int i: bloomDay){
            maxi= Math.max(maxi,i);
            mini= Math.min(mini, i);
        }

        int low= mini;
        int high= maxi;

        int ans=-1;

        while(low<= high){
            int mid=(high+low)/2;
            boolean ispossible=ifPossible(bloomDay, mid, k,m);
            if(ispossible==true){
                ans=mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
}