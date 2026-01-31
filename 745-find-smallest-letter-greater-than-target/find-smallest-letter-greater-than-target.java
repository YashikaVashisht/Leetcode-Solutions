class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int t=target; 

        for(char ch :letters) {
            if(ch>t) { 
                return ch;
            }
        }
        return letters[0]; 
    }
}