class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        int l=0;
        int r=0;
        int maxLen=0;

        while(r<fruits.length){
            if(!hm.containsKey(fruits[r])){
               hm.put(fruits[r], 1); 
            } 
            else{
                hm.put(fruits[r] , hm.get(fruits[r]) +1);
            }
            if(hm.size()> 2){ //shrinking the left most
                while(hm.size() > 2){
                    hm.put(fruits[l] , hm.get(fruits[l]) -1);
                    if(hm.get(fruits[l])==0){
                        hm.remove(fruits[l]);
                    }
                    l++;
                }
                
            }
            if(hm.size() <= 2){
                maxLen=Math.max(maxLen, r-l+1);
            }

            
            r++;
        }
        return maxLen;
    }
}