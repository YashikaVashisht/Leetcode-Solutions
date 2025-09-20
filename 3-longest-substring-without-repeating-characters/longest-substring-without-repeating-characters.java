class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hm= new HashMap<>();
        int n= s.length();
        int maxLen=0;
        int l=0,r=0;

        while(r<= n-1){
            char ch= s.charAt(r);
            if( hm.containsKey(ch) ){
                if(hm.get(ch) >= l){ //checking if r is after the l 
                    l=hm.get(ch)+1;
                    
                }  
            }
            hm.put(ch,r);
            int len= r-l+1;
            maxLen=Math.max(maxLen, len);
            r++;
        }
        return maxLen;
    }
    
}