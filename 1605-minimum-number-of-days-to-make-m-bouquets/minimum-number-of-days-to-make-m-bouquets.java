class Solution {
    public boolean helper(int[] bloomDay, int m, int k, int day){
        int count=0;
        for(int d:bloomDay){
            if(d<=day){//checking if the flower bloomed or not 
                count++; //adjacent flower added
                if(count==k){
                    m--; //baout made
                    count=0;// start counting for the next bouquet
                    if (m == 0)
                    return true;
                }
            }else{
                //break adjacent
                count=0;
            }
        }
      
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int mini=Integer.MAX_VALUE;
        int maxi=-1;
        for(int i: bloomDay){
            maxi= Math.max(maxi,i);
            mini= Math.min(mini, i);
        }

        int l= mini;
        int r= maxi;
        int ans=-1;
        while(l<=r){
            int mid= (l+r)/2;
            boolean possible= helper(bloomDay, m , k , mid);
            if(possible==true){
                ans= mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;

    }
}