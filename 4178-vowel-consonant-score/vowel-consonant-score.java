class Solution {
    public int vowelConsonantScore(String s) {
        int vowels = 0;
        int consonants = 0;
        HashSet<Character> set = new HashSet();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        for(int i = 0; i< s.length(); i++){
            if(set.contains(s.charAt(i))){
                vowels++;
            }
            else if((s.charAt(i) - 'a') > 0 && (s.charAt(i) - 'a') <=26){
                consonants++;
            }
        }

        if(consonants > 0){
            return (int)Math.floor(vowels/consonants);
        }
        return 0;
    }
}