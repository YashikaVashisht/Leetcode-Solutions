// class Solution {
//     public String decodeString(String s) {
//         int n=s.length();
//         StringBuilder sub = new StringBuilder();
//         Stack<String> st=new Stack<>();
//         for(int i=0;i<n;i++){
//             char ch=s.charAt(i);
//             if(ch==']'){
//                 StringBuilder sub = new StringBuilder();
//                 while(!st.Isempty() && st.peek()=='['){
//                     sub.append(st.pop());
//                 }
//                 int num=st.pop();
//                 for(int j=0;j<num;j++){
//                     sub.append(sub);
//                 }
//                 if(st)
//             }else{
//                 st.push();
//             }

//         }
//     }
// }
class Solution {
    public String decodeString(String s) {
        Stack<String> st = new Stack<>();

        for (char ch : s.toCharArray()) {

            // push normal character
            if (ch != ']') {
                st.push(String.valueOf(ch));
                continue;
            }

            // -------------------------------------------
            // When ']' is found → pop till '['
            // -------------------------------------------

            StringBuilder sub = new StringBuilder();
            while (!st.isEmpty() && !st.peek().equals("[")) {
                sub.insert(0, st.pop());   // prepend because stack reverses
            }

            st.pop(); // remove '['

            // -------------------------------------------
            // Now get the number before '['
            // -------------------------------------------

            StringBuilder numStr = new StringBuilder();
            while (!st.isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                numStr.insert(0, st.pop()); // prepend digits
            }

            int repeat = Integer.parseInt(numStr.toString());

            // -------------------------------------------
            // Build repeated substring
            // -------------------------------------------

            StringBuilder finalStr = new StringBuilder();
            for (int i = 0; i < repeat; i++) {
                finalStr.append(sub);
            }

            // push back the expanded substring
            st.push(finalStr.toString());
        }

        // Final answer: concatenate stack
        StringBuilder ans = new StringBuilder();
        for (String str : st) ans.append(str);

        return ans.toString();
    }
}
