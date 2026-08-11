class Solution {
    class Pair{
        char ch;
        int freq;
        Pair(char ch , int freq){
            this.ch= ch;
            this.freq= freq;
        }
    }
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> y.freq-x.freq);
        if(a>0) pq.offer(new Pair('a', a));
        if(b>0) pq.offer(new Pair('b', b));
        if(c>0) pq.offer(new Pair('c', c));

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Pair first= pq.poll();
            char chr = first.ch;
            int len = sb.length(); //curr answer length

            // if curr sb = 'aa' 'bb' 'cc'
            if(len>=2 && sb.charAt(len-1)==chr && sb.charAt(len-2)==chr){
                //moving to next unqiue element
                if(pq.isEmpty()) break;
                Pair second= pq.poll();
                sb.append(second.ch);
                second.freq--;
                //updating the freq
                if(second.freq > 0){
                    pq.offer(second);
                }
                pq.offer(first);
            }else{
                sb.append(chr);
                first.freq--;
                if(first.freq > 0) pq.offer(first);
            }
        }
        return sb.toString();
    }
}