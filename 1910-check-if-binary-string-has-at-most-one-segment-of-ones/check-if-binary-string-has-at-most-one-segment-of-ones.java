// class Solution {
//     public boolean checkOnesSegment(String s) {
//         if(s.length()<=1 && s.charAt(0)== '1') return true;
//         for(int i=1;i<s.length(); i++){
//             if(s.charAt(i)=='1' && s.charAt(i-1)=='1'){
//                 return true;
//             }
//         }
//         return false;
//     }

// }
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}