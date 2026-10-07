class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set= new HashSet<>();
        int l=0;
        int r=0;
        int ans=0;
        while(r< s.length()){
            char ch = s.charAt(r);

            while(set.contains(ch)){
                set.remove(s.charAt(l));
                l++;
            }
            set.add(ch);
            ans=Math.max(ans,r-l+1);
            r++;
            
        }
        return ans;

    }
}