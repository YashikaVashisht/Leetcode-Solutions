class Solution {
    public int helper(int[][] dp,List<List<Integer>> triangle, int i, int j){
        int n = triangle.size();
        if(i== n-1) return triangle.get(i).get(j);
        
        if(dp[i][j] != -2) return dp[i][j];

        return dp[i][j] = triangle.get(i).get(j) +Math.min(helper(dp,triangle, i+1,j), helper(dp, triangle, i+1, j+1));

    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n= triangle.size();
        int[][] dp = new int[n][n];
        for(int[] itr: dp){
            Arrays.fill(itr, -2);
        }
        int low = Integer.MAX_VALUE;
        int ind=0;
        // for(int i= 0; i< triangle.get(n-1).size(); i++){
        //     if(low> triangle.get(n-1).get(i)){
        //         ind = i;
        //     }
        // }
        return helper(dp, triangle,0,0);

        
        
        // int total = triangle.get(0).get(0);
        // int index = 0;
        //  for (int i = 1; i < triangle.size(); i++) {
        //     List<Integer> row = triangle.get(i);
        //     int left = row.get(index);
        //     int right = row.get(index + 1);

        //     if (right < left) {
        //         total += right;
        //         index = index + 1;  
        //     } else {
        //         total += left;
    
        //     }
        // }

        // return total;

        
        // int n=triangle.size();
        // int[][] dp = new int[n][n];
        // for(int[] is: dp){
        //     Arrays.fill(is, -1);
        // }
       
        // int dp[] = new int[n+1];
        // for(int i=n-1;i>=0;i++){
        //     List<Integer> row = triangle.get(i);
        //     for(int j=0;j< row.size();j++){
        //         dp[j]=Math.min(dp[j],dp[j+1])+row.get(j);
        //     }
        // }
        // return dp[0];
        
    }
}