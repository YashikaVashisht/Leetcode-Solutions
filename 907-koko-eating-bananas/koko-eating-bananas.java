class Solution {
    public long calHours(int[] arr, int k){ //calculating for the possible value for k
        long poss=0;  
        for(int i=0;i<arr.length;i++){
            if(arr[i] <=k){ 
                poss+=1;
            }else{
                poss+=(long) Math.ceil((double)arr[i]/k); 
            }
        }
        return poss;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int maxi=-1;
        for(int i: piles){
            maxi=Math.max(maxi,i);
        }
        // System.out.println(maxi);

        int ans=0;
        int low=1;
        int high=maxi;
        while(low<=high){
            int mid=(high+low)/2;
            long req= calHours(piles,mid);
            // System.out.println(req);

            if(req <= h){
                ans=mid;
                high=mid-1;
            }else{
                low= mid+1;
            }
        }
        return ans;
    }
}