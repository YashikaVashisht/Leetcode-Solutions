class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());

        for(int num: stones){
            pq.offer(num);
        }

        while(pq.size()>1){
            int p = pq.poll();
            int q = pq.poll();
            pq.offer(p-q);
        }
        return pq.peek();

    }
}