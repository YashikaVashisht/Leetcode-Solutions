class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm= new HashMap<>();
        int m = s.length();
        int n= t.length();
        for(int i=0;i<n;i++){
            char ch= t.charAt(i);
            hm.put(ch, hm.getOrDefault(ch,0)+1);
        }
        int minWin= Integer.MAX_VALUE;
        int count= n;
        int i=0;
        int j=0;
        
        int start_i=0; // for future storing the substring

        while(j<m){
            char ch=s.charAt(j);

            if(hm.containsKey(ch) &&  hm.get(ch) > 0) { // checking if the curr char is in our map with some frq
            // if yes then it is required
                count--;

            }
            if(hm.containsKey(ch)){
                hm.put(ch, hm.get(ch) - 1);
            }// decremneting the freq in map 

            while(count == 0) { // if all character are being covered
                int curr= j-i+1;
                if(minWin> curr){
                    minWin=curr;
                    start_i=i;
                }

                //start shrinking thr window. by i by increaming the ith
                char leftChar = s.charAt(i);

                if(hm.containsKey(leftChar)){
                    hm.put(leftChar, hm.get(leftChar)+1);
                    if(hm.get(leftChar) > 0){
                        count++;
                    }
                }
                i++;
            }
            j++;
        }

        if(minWin==Integer.MAX_VALUE) return "";
        else{
            return s.substring(start_i, start_i + minWin);

        }
    }
}