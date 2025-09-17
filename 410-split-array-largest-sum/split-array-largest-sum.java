class Solution {

   public int calStudent(int[] arr, int limit){
        int student=1;
        int pages=0;
        for(int i=0;i<arr.length;i++){
            if(pages+arr[i] <= limit){
                pages+=arr[i];
            }else{
                student++;
                pages=arr[i];// restart with 0
            }
        }
        return student;
    }
    public int splitArray(int[] arr ,int k) {
        int n= arr.length;
        if(k>n) return -1;
        
        int sum=0;
        int maxi=-1;
        for(int i: arr){
            maxi= Math.max(maxi,i);
            sum+=i;
        }
        // int ans=-1;
        int low= maxi;
        int high=sum;
        while(low<=high){
            int mid=(low+high)/2;
            int std= calStudent(arr,mid);
            if(std<=k){
                high=mid-1;
            }else{
                // ans= mid;
                low=mid+1;
            }
        }
        return low;
    }
}