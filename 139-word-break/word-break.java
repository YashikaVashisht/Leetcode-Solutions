class Solution {
    public boolean helper(String s,  HashSet<String> hs ,int i,  Boolean[] dp ) {
        if(i==s.length()){
            return true;
        }
        if(dp[i] != null) return dp[i];

        for(int k =i;k<s.length();k++){
            String word=s.substring(i, k+1);
            if(hs.contains(word)){
                boolean check= helper(s, hs, k+1, dp);
                if(check==true) return dp[i]=true;
            }
        }
        return dp[i] =false;

    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[s.length()];
        return helper(s, hs, 0, dp);
    }
}