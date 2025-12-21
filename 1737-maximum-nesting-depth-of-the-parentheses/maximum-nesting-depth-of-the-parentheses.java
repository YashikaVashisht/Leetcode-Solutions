class Solution {
    public int maxDepth(String s) {
        int currDepth = 0;
        int maxDepth = 0;

        for(char c : s.toCharArray()) {

            if(c == '(') {
                currDepth++;
                maxDepth = Math.max(maxDepth, currDepth);
            } 
            else if(c == ')') {
                currDepth--;
            }

        }

        return maxDepth;
    }
}
