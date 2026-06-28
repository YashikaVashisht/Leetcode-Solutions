class Solution {
    // it find the  totoal trips in t times possible
    public long calculatetrips(int[] time, long t){
        long trips=0;
        for(int i=0;i<time.length;i++){
            trips+= t/time[i];
        }
        return trips;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int min=Integer.MAX_VALUE;
        for(int i:time) {
            min=Math.min(min, i);
        }
        long l = 1;                             
        long r = (long) min * totalTrips;        
        long ans = 0;   
        while(l<=r){
            long mid= (l+r)/2;
            long trips= calculatetrips(time, mid);
            if(trips >= totalTrips){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}