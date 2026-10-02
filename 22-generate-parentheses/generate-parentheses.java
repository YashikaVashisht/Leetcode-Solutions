class Solution {
    public void helper(String s, int open , int close, ArrayList<String>  ans){
        if(open==0 && close==0){
            ans.add(s);
            return;
        }
        char op='(';
        char cl=')';
        if(open>0){
            helper(s+op, open-1, close, ans);
        }
        
        if(open<close){
             helper(s+cl, open, close-1, ans);
        }

       
    }
    
    public List<String> generateParenthesis(int n) {
        int open=n, close=n;
        ArrayList<String>  ans= new ArrayList<>();
        String s="";
        helper(s, open, close, ans);
        return ans;
    }
}