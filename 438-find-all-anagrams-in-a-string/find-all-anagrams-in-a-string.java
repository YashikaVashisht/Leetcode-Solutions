class Solution {
    boolean allZero(int[] arr){
        for(int ch:arr){
            if(ch!=0) return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String txt, String pat) {
        int[] freq= new int[26];
        List<Integer> res= new LinkedList<>();
        for(int i=0;i<pat.length();i++){
            char ch= pat.charAt(i);
            freq[ch-'a']++;
        }
        
        int l=0;
        int r=0;
        int k= pat.length();
        
        while(r<txt.length()){
        
            freq[ txt.charAt(r) -'a']--; // dcreseing the count of rth char from freq array
            //checking if the window equals to pat
            if(r-l+1 == k){
                if(allZero(freq)){ //if all zero then yes its a match
                    res.add(l);
                }
                
                freq[ txt.charAt(l)-'a' ]++; //new shrinking the window by refetching the decresed freq 
                l++;// lshift by 1 
            }
            r++;
        }
        return res;
          
    }
}