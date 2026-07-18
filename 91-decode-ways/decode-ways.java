class Solution {
    int n;
    public int helper(String s, int i,  Integer[] dp ){
        if( i==n) return 1;
        if (s.charAt(i)=='0') return 0;
        if (dp[i]!=null) return dp[i];
        int ways= helper(s, i+1 ,dp);

        if(i+1 < s.length()){
            String s1 = s.substring(i, i+2);
            int num= Integer.parseInt(s1);
            if (num >= 10 && num <= 26) {
                ways += helper(s, i + 2, dp);
            }

        }
        return dp[i]= ways;

    }
    public int numDecodings(String s) {
        n= s.length();
        Integer[] dp = new Integer[n];
        return helper(s, 0 , dp);
    }
}