class Solution {
    public int maxTwoEvents(int[][] events) {

        // Sort by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));

        // Min heap based on end time
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[1], b[1])
        );

        int maxValue = 0;
        int ans = 0;

        for(int[] event : events) {

            int start = event[0];
            int value = event[2];

            // Remove all events that finish before current event starts
            while(!pq.isEmpty() && pq.peek()[1] < start) {
                int[] previous = pq.poll();
                maxValue = Math.max(maxValue, previous[2]);
            }

            // Take current event + best compatible previous event
            ans = Math.max(ans, maxValue + value);

            // Add current event
            pq.offer(event);
        }

        return ans;
    }
}