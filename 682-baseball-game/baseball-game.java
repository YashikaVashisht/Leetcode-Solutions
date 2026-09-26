class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s= new Stack<>();
        for(int i=0;i<operations.length;i++){
            String str= operations[i];
            if(str.equals("C")){
                s.pop();
            }else if(str.equals("+")){
                int top= s.pop();
                int second= s.peek();

                s.push(top);
                s.push(top+second);

            }else if(str.equals("D")){
                s.push(s.peek()*2);
            }else{
                s.push(Integer.parseInt(str));
            }
        }
        int res=0;
        while(!s.isEmpty()){
            res+= s.pop();
        }
        return res;
        
    }
}