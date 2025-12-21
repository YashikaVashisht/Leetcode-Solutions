// class Solution {
//     public String frequencySort(String s) {
//         TreeMap<Character,Integer> tm= new TreeMap<>(Collections.reverseOrder());
//         for(int i=0;i<s.length();i++){
//             char ch = s.charAt(i);
//             if(tm.containsKey(ch)){
//                 tm.put(ch,tm.get(ch)+1);
//             }else{
//                 tm.put(ch,1);
//             }
//         }
//         StringBuilder res=new StringBuilder();
//         for(char ch:tm.keySet()){
//             int val=tm.get(ch);
//             while(val-- >0){
//                 res.append(ch);
//             }
//         }
//         return res.toString();

    
//     }
// }
class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> hm = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }

        List<Character> list = new ArrayList<>(hm.keySet());


        list.sort((a, b) -> hm.get(b) - hm.get(a));

        StringBuilder res = new StringBuilder();

        for (char ch : list) {
            int val = hm.get(ch);
            while (val-- > 0) {
                res.append(ch);
            }
        }

        return res.toString();
    }
}
