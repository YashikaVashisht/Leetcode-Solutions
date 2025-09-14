class Solution {
    public static boolean bs(int[] arr, int target){
        int left=0;
        int right=arr.length-1;
        while(left<=right){
            int mid= (left+right)/2;
            if(arr[mid] == target){
                return true;
            }else if( arr[mid] > target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return false;

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int n= matrix.length;
        int m= matrix[0].length;

        int l=0;
        int r=n-1;
        int row=0;

        while(l<=r){
            int mid=(l+r)/2;
            if(matrix[mid][0] <= target && matrix[mid][m-1] >= target){
                row=mid;
                break;
            }else if(matrix[mid][0] > target){
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return bs(matrix[row], target);
    }
}