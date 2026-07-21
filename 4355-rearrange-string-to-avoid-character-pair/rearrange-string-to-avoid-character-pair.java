class Solution {
    public String rearrangeString(String s, char x, char y) {
        int cx= 0;
        int cy=0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch==x){
                cx++;
            }else if(ch==y){
                cy++;
            }else{
                sb.append(ch);
            }
        }
        StringBuilder res = new StringBuilder();
        while(cy-- >0){
            res.append(y);
        }
        res.append(sb);
        while(cx-- >0){
            res.append(x);
        }

        return res.toString();
        
        
    

    }
}