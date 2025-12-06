class Solution {
    public int largestAltitude(int[] gain) {
        int n=gain.length;
        int[] prefix= new int[n+1];
        prefix[0]=0;
        int max=0;
        for(int i=1;i<=n;i++){
            prefix[i]=prefix[i-1]+gain[i-1];
            
        }
        for(int num:prefix){
            max=Math.max(max, num);
        }
        return max;
      



    }
}