class Solution {
    public String largestGoodInteger(String num) {
        String s="";
        int max=-1;
        for(int i=1;i<num.length()-1;i++){
            if((num.charAt(i-1)==num.charAt(i))  && (num.charAt(i+1)==num.charAt(i))){
                s = "" +num.charAt(i-1)+ num.charAt(i-1) + num.charAt(i-1); 
                int val = Integer.parseInt(s);
                if(val > max) {
                    max=val;
                }
                
            }
        }

        if (max == -1) return "";

        if (max == 0) return "000";
        return String.format("%03d", max);
    }
}