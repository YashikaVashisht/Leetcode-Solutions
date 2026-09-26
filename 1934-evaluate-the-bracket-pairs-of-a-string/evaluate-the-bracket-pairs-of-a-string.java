class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        HashMap<String, String> hm = new HashMap<>();
        
        for(List<String> l: knowledge){
            hm.put(l.get(0), l.get(1));
        }
        StringBuilder res= new StringBuilder();
        for(int i=0;i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch=='('){
               StringBuilder sb= new StringBuilder();
               i++; 
               while(s.charAt(i) != ')'){
                    sb.append(s.charAt(i));
                    i++;
               }
               String key = sb.toString();
               if(hm.containsKey(key)){
                    res.append(hm.get(key));
               }else{
                res.append("?");
               }
            }else{
                res.append(ch);
            }
        }

        return res.toString();
    }
}