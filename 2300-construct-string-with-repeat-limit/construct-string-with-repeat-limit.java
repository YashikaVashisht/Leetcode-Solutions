class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch , int freq){
            this.ch= ch;
            this.freq= freq;
        }
    }
    public String repeatLimitedString(String s, int repeatLimit) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.ch-a.ch);

        int[] freq=new int[26];
        for(char ch:s.toCharArray()) {
            freq[ch-'a']++;
        }

        for(int i=0; i<26; i++) {
            if(freq[i]>0) {
                pq.offer(new Pair((char)(i+'a'), freq[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first= pq.poll();

            int use= Math.min(first.freq, repeatLimit);
            // times for repeating the curr ch

            for(int i=0;i<use;i++){
                sb.append(first.ch);
                first.freq--;
            }
            // We used all of this character
            if(first.freq==0) {
                continue;
            }

            if(pq.isEmpty()) break;
            // Need a smaller character as separator.

            Pair second = pq.poll();
            sb.append(second.ch);
            second.freq--;

            if(second.freq>0) {
                pq.offer(second);
            }

            pq.offer(first);


        }
        return sb.toString();
    }
}