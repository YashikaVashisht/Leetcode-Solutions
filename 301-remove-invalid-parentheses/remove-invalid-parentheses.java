class Solution {
    HashSet<String> set=new HashSet<>();
    public List<String> removeInvalidParentheses(String s) {
        int open=0;
        int close=0;

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);

            if(ch=='('){
                open++;
            }else if(ch==')'){
                if(open>0){
                    open--;
                }else{
                    close++;
                }
            }
        }

        solve(s,0,open,close,0,new StringBuilder());

        return new ArrayList<>(set);
    }

    public void solve(String s,int i,int open,int close,
                      int count,StringBuilder sb){

        if(i==s.length()){
            if(open==0 && close==0 && count==0){
                set.add(sb.toString());
            }
            return;
        }

        char ch=s.charAt(i);

        if(ch=='('){
            // remove
            if(open>0){
                solve(s,i+1,open-1,close,count,sb);
            }

            // keep
            sb.append(ch);
            solve(s,i+1,open,close,count+1,sb);
            sb.deleteCharAt(sb.length()-1);

        }else if(ch==')'){
            // remove
            if(close>0){
                solve(s,i+1,open,close-1,count,sb);
            }
            // keep only if valid
            if(count>0){
                sb.append(ch);
                solve(s,i+1,open,close,count-1,sb);
                sb.deleteCharAt(sb.length()-1);
            }

        }else{
            sb.append(ch);
            solve(s,i+1,open,close,count,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}