class Solution {
    public int minCost(String s, int[] neededTime) {
        int prev=0;
        int time=0;
        int n= s.length();
        for(int i=0;i<n;i++){
            if(i>0 && s.charAt(i) != s.charAt(i-1)){
                prev=0;
            }
            int curr=neededTime[i];
            time+=Math.min(prev, curr);
            prev=Math.max(prev,curr);
        }
        return time;
        
    }
}