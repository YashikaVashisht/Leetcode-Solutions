class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch== ')'){
                // Stack<Character> temp= new Stack<>();
                StringBuilder temp = new StringBuilder();
                while(!st.isEmpty() && st.peek()!= '('){
                    // temp.push(st.pop());
                     temp.append(st.pop());
                }
                st.pop(); // '('
                // while(!temp.isEmpty()){
                //     st.push(temp.pop());
                // }
                for(int j = 0; j < temp.length(); j++) {
                    st.push(temp.charAt(j));
                }
            }else{
                st.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
    
}