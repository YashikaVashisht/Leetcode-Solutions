class Solution {
    public boolean validMountainArray(int[] arr) {
        int n=arr.length;
        int i=0;
        while(i+1<n && arr[i]<arr[i+1]){
            i++;
        }
        //peak found
        if(i==n-1 ||i==0) return false; // 0th or n-1th cant be peak 

        while(i+1<n && arr[i]>arr[i+1]){
            i++;
        }
        if(i==n-1) return true;
        return false;

    }
}