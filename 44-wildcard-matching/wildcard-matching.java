class Solution {
    int dp[][];
    public boolean helper( String s, String p, int i, int j){
        if(i<0 && j<0) return true;
        if(j<0 && i>=0) return false;// if s is finished and p is left
        if(i<0 && j>=0) {
            for(int k = 0; k<=j ; k++){
                if(p.charAt(k) != '*'){  // p is finished with * and s is pending ,then it will match
                    return false;
                }
            }
            return true; //matches
        }
        if(dp[i][j] != -1) return dp[i][j]==1;

        boolean ans = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?'){
            ans= helper(s,p,i-1, j-1);
        }
        if(p.charAt(j) == '*'){
            ans= helper(s,p,i-1,j) || helper(s,p,i,j-1);
        }
        dp[i][j] = ans ? 1 : 0;
        return ans;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n= p.length();
        dp= new int[m][n];
        for (int[] row : dp)
            Arrays.fill(row, -1);

        return helper(s ,p, m-1, n-1);
    }
}