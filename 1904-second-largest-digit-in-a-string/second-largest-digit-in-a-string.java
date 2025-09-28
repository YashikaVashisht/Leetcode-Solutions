class Solution {
    public int secondHighest(String s) {
        ArrayList<Integer> digits = new ArrayList<>();
        
        for (char ch : s.toCharArray()) {   
            if (Character.isDigit(ch)) {
                digits.add(ch - '0');       
            }
        }
 
        Set<Integer> unique = new HashSet<>(digits);
        
        if (unique.size() < 2) {
            return -1; 
        }
        

        ArrayList<Integer> sorted = new ArrayList<>(unique);
        Collections.sort(sorted, Collections.reverseOrder());
        
        return sorted.get(1);
    }
}