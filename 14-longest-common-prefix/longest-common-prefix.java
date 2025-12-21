class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs==null || strs.length==0) {
            return "";
        } 
        String ans="";
        String s=strs[0];
        
        for (int i=0; i<s.length(); i++) {
            char letter=s.charAt(i);
            for (int j=1; j<strs.length;j++) {
                String word=strs[j];
                if (i>=word.length() || letter!=word.charAt(i)) {
                    return ans;
                }
            }  
            ans+=letter;  
        }
        
        return ans;
    }
}
