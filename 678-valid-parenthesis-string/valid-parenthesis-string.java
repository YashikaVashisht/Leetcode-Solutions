class Solution {
    public boolean checkValidString(String s1) {
        int minOpen=0, maxOpen=0;
        for(int i=0;i<s1.length();i++){
            char ch= s1.charAt(i);
            if(ch=='('){
                minOpen++;
                maxOpen++;
            }else if(ch==')'){
                minOpen= Math.max(0,minOpen-1);
                maxOpen--;
            }else{
                minOpen= Math.max(0,minOpen-1);
                maxOpen++;
            }
            if(maxOpen<0) return false;

        }
        return minOpen==0;

    }
}