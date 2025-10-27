class Solution {
    public String getEncryptedString(String s, int k) {
        String res = "";
        int n = s.length();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt((i + k) % n);  
            res += ch;                        
        }

        return res;
    }
}