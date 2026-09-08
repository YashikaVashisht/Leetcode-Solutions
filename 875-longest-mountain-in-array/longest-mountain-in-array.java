class Solution {
    public int longestMountain(int[] arr) {
        int i=0;
       int n = arr.length;
       int maxi=0;
        while(i<n-1){
            int l=i;
            while (i<n-1 && arr[i]<arr[i+1]) {
                i++;
            }
            int peak=i;

            while (i<n-1 && arr[i]> arr[i+1]) {
                i++;
            }
     
            if (peak > l && i > peak) {
                maxi = Math.max(maxi, i - l + 1);
            }

            if (i==l) {
                i++;
            }
        }
        return maxi;
    }
}