class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s= new Stack<>();
        int n=popped.length;
        int pos=0;
        // for(int i=0;i<n;i++){
        //     int popOut=popped[i];
            
        //     while(pos<pushed.length){
        //         s.push(pushed[pos]);
        //         if(s.peek()==popOut){
        //             s.pop();
        //             break;
        //         }
        //         pos++;
        //     }
        // }
        for (int i = 0; i < pushed.length; i++) {
            s.push(pushed[i]);

            while (!s.isEmpty() && pos < n && s.peek() == popped[pos]) {
                s.pop();
                pos++;
            }
        }
        if(s.isEmpty()){ 
            return true;
        }else{
            return false;
        }
    }
}