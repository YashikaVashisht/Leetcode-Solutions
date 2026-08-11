class Solution {
    class Pair{
        int val;
        int lab;
        Pair(int val , int lab){
            this.val=val;
            this.lab=lab;
        }
    }
    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> b.val- a.val);
        for (int i=0; i<values.length;i++) {
            pq.offer(new Pair(values[i], labels[i]));
        }
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans= 0;
        int count=0;

        while(!pq.isEmpty() && count < numWanted){
            Pair curr= pq.poll();
            int freq= hm.getOrDefault(curr.lab , 0);

            if(freq< useLimit){//means havent included curr yet
                ans+=curr.val;
                count++;

                hm.put(curr.lab, freq+1);//updating the freq so that limit can tbe crossed
            }

        }
        return ans;
    }
}