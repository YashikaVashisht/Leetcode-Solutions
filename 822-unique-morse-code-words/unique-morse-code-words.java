class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse= {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        int n= words.length;
        Set<String> set = new HashSet<>();

        for(int i=0;i<n;i++){
            String word=words[i];
            String code="";
            for(char ch: word.toCharArray()){
                code+= morse[ch-'a'];
            }
            set.add(code);
        }
        return set.size();

    }
}