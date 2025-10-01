class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st=new Stack<>();
        StringBuilder sb = new StringBuilder();

        // st.push(s.charAt(0));
        // for(int i=1;i<s.length();i++){
        //     char ch = s.charAt(i);
        //     if(ch==st.peek()){
        //         continue;
        //     }else{
        //         st.push(ch);
        //     }
        //  }
        // while(!st.isEmpty()){
        //     sb.append(st.pop());
        // }
        // sb.reverse();  
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (!st.isEmpty()) {  
                    sb.append(ch);
                }
                st.push(ch);
            } else { 
                st.pop();
                if (!st.isEmpty()) {   
                    sb.append(ch);
                }
            }
        }


        return sb.toString();

    }
}