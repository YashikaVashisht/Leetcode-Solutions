class Solution {
    int[][] dp ;
    public int helper(String s1, String s2, int i , int j){
        if(i<0 || j<0 ) return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return dp[i][j]= (int) s1.charAt(i) + helper(s1, s2, i-1, j-1);
        }else{
            return dp[i][j]= Math.max( helper(s1, s2, i-1,j) , helper(s1, s2, i,j-1) );
        }
    }
    public int minimumDeleteSum(String s1, String s2) { 
        // so basically we will find ascii value of lcs and  subteact from the sum of s1 and s2 ascii values;

        int m= s1.length();
        int n= s2.length();

        dp = new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        int total = 0;
        for(int i=0;i<m;i++){
            total+= s1.charAt(i);
        }
        for(int i=0;i<n;i++){
            total+= s2.charAt(i);
        }

        int ascii_of_lcs= 2* helper(s1, s2, m-1, n-1);
        return total - ascii_of_lcs;

    }
}