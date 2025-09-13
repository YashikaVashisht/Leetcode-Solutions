class Solution {
    public String sortVowels(String s) {
        StringBuilder sb= new StringBuilder();
        ArrayList<Character> vowels= new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A'|| ch=='E'|| ch=='I'|| ch=='O'|| ch=='U'){
                vowels.add(ch);
                sb.append('_');
            }else{
                sb.append(ch);
            }
        }

        Collections.sort(vowels);

        int j=0;
        for(int i=0;i<sb.length();i++){
            if(sb.charAt(i)=='_'){
                sb.setCharAt(i, vowels.get(j));
                j++;
            }
        }
        return sb.toString();
    }
}