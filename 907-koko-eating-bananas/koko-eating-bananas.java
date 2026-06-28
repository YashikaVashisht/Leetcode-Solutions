class Solution {
    //hours calculating functions
    public int hours(int[] piles, int k){
        int hours=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i] <=k ){
                hours+=1;
            }else{
                hours+= Math.ceil((double)piles[i]/k);
            }
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int l=1;
        int n= piles.length;
        int maxi=0;
        int ans=0;
        for(int i:piles){
            maxi=Math.max(maxi, i);
        }
        int r= maxi;

        while(l<=r){
            int mid= (l+r)/2; // a possible va;ue og k
            int tempK= hours(piles, mid);
            if(tempK<=h){
                ans= mid;
                r= mid-1;
            }else{
                l=mid+1;
            }

        }
        return ans;
    }

}