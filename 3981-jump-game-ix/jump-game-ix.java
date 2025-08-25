class Solution {
    public int[] maxValue(int[] nums) {
        int n=nums.length;
        int[] prefixMax= new int[n];
        int[] suffixMin= new int[n];


        int[] res= new int[n];

        prefixMax[0]=nums[0];
        for(int i=1;i<n;i++){
            prefixMax[i]=Math.max(prefixMax[i-1],nums[i]);
        }

        suffixMin[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            suffixMin[i]=Math.min(suffixMin[i+1], nums[i]);
        }

        res[n-1]=prefixMax[n-1];
        for(int i=n-2;i>=0; i--){
            res[i]=prefixMax[i];
            if(prefixMax[i]> suffixMin[i+1]) res[i]=res[i+1];
            
        }
        return res;

    }
}