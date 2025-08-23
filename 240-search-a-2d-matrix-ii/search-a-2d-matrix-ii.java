class Solution {
    public static boolean helper(int arr[], int start, int end, int target){
        while(start<=end){
            int mid=(start+end)/2;
            if(arr[mid]==target){
                return true;
            }else if(arr[mid] <=target){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] mat, int target) {
        int n=mat.length;
        int m=mat[0].length;
        for(int[] arr: mat){
            boolean found=helper(arr,0,m-1,target);
            if(found==true){
                return true;
            }
        }
        return false;
    }
}