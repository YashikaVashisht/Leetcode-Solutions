class Solution {
    public String generateTag(String caption) {
        StringBuilder res= new StringBuilder();
        res.append("#");
        
        String[] words = caption.split(" ");
        boolean isFirstWord = true;

        for(int i=0;i<words.length;i++){
            String word= words[i];
            if(word.isEmpty()) continue; // whiteSpace

            word=word.toLowerCase();

            if (!isFirstWord) { 
                word = Character.toUpperCase(word.charAt(0)) + word.substring(1);
            }

            res.append(word);
            isFirstWord = false;
        }

        if(res.length() >100){ //turncate
            return res.substring(0,100);
        }

        return res.toString();
    }
}