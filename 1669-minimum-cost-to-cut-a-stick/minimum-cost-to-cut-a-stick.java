import java.util.*;
class Solution {
    public int helper(int cuts[], int i , int j, int[][] dp){

        if(i>j) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int min= Integer.MAX_VALUE;
        for(int k=i;k<=j;k++){
            int cost= cuts[j+1]- cuts[i-1]+ helper(cuts,i,k-1, dp)+helper(cuts, k+1, j, dp);
            min= Math.min(min, cost);


        }

        return dp[i][j]= min;
    }
    public int minCost(int n, int[] arr) {
        int m= arr.length;

        int[] cuts= new int[m+2];

        int[][] dp= new int[m+2][m+2];
        for(int []i: dp){
            Arrays.fill(i,-1);
            
        }
        cuts[0]=0;
        for(int i=0;i<m;i++){
            cuts[i+1]=arr[i];
        }
        cuts[m+1]=n;

        Arrays.sort(cuts);    
        
        return helper(cuts, 1, m, dp);
        
    }
}