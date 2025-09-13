class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowels= new HashMap<>();
        HashMap<Character, Integer> con= new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='a' ||ch=='e' || ch=='i'|| ch=='o' ||ch=='u'){
                if(vowels.containsKey(ch)){
                    vowels.put(ch,vowels.get(ch)+1);
                }else{
                    vowels.put(ch,1);
                }
            }else{
                if(con.containsKey(ch)){
                    con.put(ch,con.get(ch)+1);
                }else{
                    con.put(ch,1);
                }

            }
        }

        int max1=0;
        int max2=0;
        for(char ch:vowels.keySet()){
            max1=Math.max(max1, vowels.get(ch));
        }
        for(char ch:con.keySet()){
            max2=Math.max(max2, con.get(ch));
        }
        return max1+max2;

    }
}