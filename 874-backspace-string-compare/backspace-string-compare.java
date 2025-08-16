class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> s1=new Stack<>();
        Stack<Character> s2=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='#'){
                if(!s1.isEmpty()) s1.pop();
            }else{
                s1.push(ch);
            }
        }
        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            if(ch=='#'){
                if(!s2.isEmpty())  s2.pop();
               
            }else{
                s2.push(ch);
            }
        }
        StringBuilder sb1=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        while(!s1.isEmpty()){
            sb1.append(s1.pop());

        }
        while(!s2.isEmpty()){
            sb2.append(s2.pop());
        }

        sb1.reverse();
        sb2.reverse();

        if(sb1.toString().equals(sb2.toString())){
            return true;
        }else return false;
    }
}