class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n= citations.length;
        int low=0;
        int ans=0;
        int high=n-1;

        while(low<=high){
            int mid= low+(high-low)/2;
            if(citations[mid] < (n-mid)){
                // ans= citations[mid];
                low=mid+1;
            }else{
                ans=n-mid;
                high=mid-1;
            }
        }
        
        return ans;
    }
}