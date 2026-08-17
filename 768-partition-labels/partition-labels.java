class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] last= new int[26];
        int n= s.length();
        //last occur of every ch
        for(int i = 0; i < n; i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        List<Integer> list= new ArrayList<>();
        int l=0;
        int r=0;
        for(int i=0;i<n;i++){
            int ch= s.charAt(i);
            r= Math.max(r, last[ch-'a']); //fiidning the maxium point till the partion go 

            if(i==r){
                list.add(r-l+1);
                l=i+1;
                
            }
        }
        return list;
    }
}