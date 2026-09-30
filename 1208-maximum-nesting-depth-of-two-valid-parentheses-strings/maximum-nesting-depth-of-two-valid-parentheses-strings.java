class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int count=0;
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            char ch = seq.charAt(i);
            if(ch=='('){
                count++;
                ans[i]=count%2;
            }else{
                ans[i] = count % 2;
                count--;
            }

        }
        return ans;

    }
}