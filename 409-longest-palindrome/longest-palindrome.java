class Solution {
    public int longestPalindrome(String s) {
         int[] freq=new int[128];

        for(char ch:s.toCharArray()) {
            freq[ch]++;
        }

        int ans=0;
        boolean Odd=false;

        for(int f:freq) {

            ans+=(f/2)*2;

            if(f%2==1) {
                Odd=true;
            }
        }

        if(Odd) {
            ans++;
        }

        return ans;
    }
}