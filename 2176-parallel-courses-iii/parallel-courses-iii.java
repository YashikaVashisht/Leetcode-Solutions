class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[n];
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : relations) {
            int u = edge[0] - 1; // convert 1-indexed to 0-indexed
            int v = edge[1] - 1;

            adj.get(u).add(v);
            indeg[v]++;
        }
        Queue<Integer> q = new LinkedList<>();

        int[] finishTime = new int[n];

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.offer(i);
                finishTime[i] = time[i];
            }
        }
         while (!q.isEmpty()) {

            int curr = q.poll();

            for (int neigh : adj.get(curr)) {

                finishTime[neigh] = Math.max(
                    finishTime[neigh],
                    finishTime[curr] + time[neigh]
                );

                indeg[neigh]--;

                if (indeg[neigh] == 0) {
                    q.offer(neigh);
                }
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, finishTime[i]);
        }

        return ans;
    }
}