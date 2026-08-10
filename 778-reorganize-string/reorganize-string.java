class Solution {

    class Pair{
        char ch;
        int freq;

        Pair(char ch,int freq){
            this.ch = ch;
            this.freq = freq;
        }
    }

    public String reorganizeString(String s) {

        int[] arr = new int[26];

        for(char ch : s.toCharArray()){
            arr[ch-'a']++;
        }

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a,b)->b.freq-a.freq);

        for(int i=0;i<26;i++){
            if(arr[i]>0){
                pq.offer(new Pair((char)(i+'a'),arr[i]));
            }
        }

        StringBuilder ans = new StringBuilder();

        while(!pq.isEmpty()){

            ArrayList<Pair> list = new ArrayList<>();

            for(int i=1;i<=2;i++){
                if(!pq.isEmpty()){
                    Pair cur = pq.poll();
                    ans.append(cur.ch);
                    cur.freq--;
                    list.add(cur);
                }
            }

            for(Pair p : list){
                if(p.freq>0)
                    pq.offer(p);
            }
            if(pq.size()==1 && pq.peek().freq>1)
                return "";
        }

        return ans.length()==s.length() ? ans.toString() : "";
    }
}