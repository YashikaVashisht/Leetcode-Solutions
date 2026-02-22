class Solution {
    public int maxVowels(String s, int k) {
        int i=0;
        int j=0;
        int count=0;
        int res= 0;
        int n= s.length();
        while(j<n){
            char ch= s.charAt(j);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u') {
                count++;
            }
            if(j-i+1 == k){
                res=Math.max(res, count);
                
                char c= s.charAt(i);
                if(c=='a' || c=='e' || c=='i' || c=='o' || c=='u') {
                    count--;
                }
                i++;
            }
            j++;
        }
        return res;
    }
}