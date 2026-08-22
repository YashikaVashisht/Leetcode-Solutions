class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int i = 0;
        int day = 1;
        int count = 0;

        while (i < events.length || !pq.isEmpty()) {

            // if no events are available, jump to next event's start day
            if (pq.isEmpty()) {
                day = events[i][0];
            }

            // Add all events that have started
            while (i < events.length && events[i][0] <= day) {
                pq.offer(events[i][1]);
                i++;
            }

            // Remove expired events
            while (!pq.isEmpty() && pq.peek() < day) {
                pq.poll();
            }

            // Attend the event ending earliest
            if (!pq.isEmpty()) {
                pq.poll();
                count++;
                day++;
            }
        }

        return count;
    }
}