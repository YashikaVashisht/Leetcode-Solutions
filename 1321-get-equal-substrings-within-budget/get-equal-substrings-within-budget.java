class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int res=0;
        int currCost=0;
        int i=0;
        int j=0;
        int n=s.length();
        while(j<n){
            currCost+= Math.abs(s.charAt(j) - t.charAt(j));
            while(currCost>maxCost){
                //shrink
                currCost-= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }
        return res;
    }
}