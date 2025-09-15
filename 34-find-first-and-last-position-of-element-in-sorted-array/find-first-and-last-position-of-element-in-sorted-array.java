class Solution {
    public static int lower_bound(int [] arr, int x){
        int n= arr.length;
        int low=0;
        int high= n-1;
        int ans= n;
        
        while(low<=high){
            int mid= (low+ high)/2;
            if(arr[mid] >= x){
                ans= mid;
                high=mid-1;  // moving to left side
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    // UPPER BOUND: smallest index of  an element which is greater than  x. (arr[mid]>x)
    public static int upper_bound(int [] arr, int x){
        int n= arr.length;
        int low=0;
        int high= n-1;
        int ans= n;
        
        while(low<=high){
            int mid= (low+ high)/2;
            if(arr[mid] >x){
                ans= mid;
                high=mid-1;
            }else{
                low=mid+1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] res= {-1,-1};
        int lb = lower_bound(nums, target);
        int ub = upper_bound(nums, target);

        
        if (lb < nums.length && nums[lb] == target) {
            res[0] = lb;       
            res[1] = ub - 1;   
        }
        return res;

    }
}