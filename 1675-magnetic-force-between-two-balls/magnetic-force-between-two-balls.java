class Solution {
    public boolean helper(int[] arr, int m, int dist){
        int count=1;
        int prev= arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i] - prev >= dist){
                count++;
                prev=arr[i];
            }
        }
        return count >= m;
    }
    public int maxDistance(int[] position, int m) {
        int n= position.length;
        Arrays.sort(position);
        int l = 1;
        int r = position[n-1]- position[0]; 
        int ans = 0;
        while(l<=r){
            int mid=(l+r)/2;
            boolean canPlace= helper(position, m , mid);
            if(canPlace==true){
                ans = mid;
                l = mid+1; 
            }else{
                r= mid - 1;
            }
        }
        return ans;
    }
}