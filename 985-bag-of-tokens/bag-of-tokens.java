class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int n=tokens.length;
        int maxi=0;
        int score=0;
        int i=0;
        int j=n-1;
        while(i<=j){
            if(power >= tokens[i]){
                power-=tokens[i];
                score++;
                i++;
                maxi=Math.max(maxi,score);
            }else if( score>=1){
                power+=tokens[j];
                score--;
                j--;
            }else{
                break;
            }

        }
        return maxi;
    }
}