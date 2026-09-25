class Solution {
    public String convert(String s, int numRows) {
        // P A Y P A L I S H I R  I  N  G
        // 0 1 2 3 4 5 6 7 8 9 10 11 12 13

        if(numRows == 1) return s;

        int n= s.length(); 
        int r=0;
        
        boolean dir= true; //true= down
        StringBuilder[] rows = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }


        for(int i=0; i<n; i++){
            rows[r].append(s.charAt(i));
            if(dir==true){
                r++;
                if(r==numRows-1){
                    dir=false;
                }
            }else{
                r--;
                if(r==0){
                    dir=true;
                }
            }
            
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numRows; i++){
            sb.append(rows[i]);
        }
        return sb.toString();
        

    }
}