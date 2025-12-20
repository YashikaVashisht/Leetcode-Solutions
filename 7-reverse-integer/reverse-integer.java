class Solution {
    public int reverse(int x) {
        int MAXI= (int)Math.pow(2,31)-1;
        int MINI=-(int) Math.pow(-2,31);
        if(x>MAXI || x<MINI){
            return 0;
        }
        String s= String.valueOf(x);
        Character sign;
        String rev="";
        if(s.charAt(0)=='-'){
            sign= s.charAt(0);
            for(int i=s.length()-1; i>0; i--){
                rev+=s.charAt(i);
            }
            rev=sign+rev;
            

        }else{
            for(int i=s.length()-1; i>=0; i--){
                rev+=s.charAt(i);
            }
            
       
            
        }
        // int res= Integer.valueOf(rev);
        // if(res> MAXI || res<MINI){
        //         return 0;
        // }else{
        //     return res;
        // } 
        try {
            int res = Integer.parseInt(rev);
            return res;
        } catch (NumberFormatException e) {
            return 0; // In case of overflow
        }   
    }
}