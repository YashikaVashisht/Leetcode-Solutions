class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return new ArrayList<>();
        HashMap<Character, String> hm = new HashMap<>();
        hm.put('2', "abc");
        hm.put('3', "def");
        hm.put('4', "ghi");
        hm.put('5', "jkl");
        hm.put('6', "mno");
        hm.put('7', "pqrs");
        hm.put('8', "tuv");
        hm.put('9', "wxyz");

        List<String>  res= new ArrayList<>();
        res.add("");
        for(int i=0; i<digits.length(); i++) {
            char d=digits.charAt(i);
            String letters=hm.get(d);

            List<String> temp = new ArrayList<>();
            for (String prefix : res) {
                for (char c:letters.toCharArray()) {
                    temp.add(prefix + c);  
                }
            }
            res = temp; 
        }
        return res;

    }
}