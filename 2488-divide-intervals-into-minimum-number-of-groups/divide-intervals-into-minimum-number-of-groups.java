class Solution {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a,b) ->Integer.compare(a[0], b[0]));

        int ans=0;
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        for(int[] arr:intervals){
            int start= arr[0];
            int end= arr[1];

            if(!pq.isEmpty() && pq.peek()< start){
                pq.poll();
            }
            pq.offer(end);
            ans = Math.max(ans, pq.size());
        }
        return ans;
    }
}