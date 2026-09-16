class Solution {
     class Pair {
        int node;
        long time;
        Pair(int node, long time) {
            this.node=node;
            this.time=time;
        }
    }
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n;i++) {
            adj.add(new ArrayList<>());
        }
        int MOD = 1000000007;
        for(int[] r:roads) {
            int u=r[0];
            int v=r[1];
            int t=r[2];
            adj.get(u).add(new int[]{v,t});
            adj.get(v).add(new int[]{u ,t});
        }
        long[] dist=new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);

        long[] ways=new long[n];

        PriorityQueue<Pair> pq =new PriorityQueue<>((a, b) -> Long.compare(a.time, b.time));
        pq.offer(new Pair(0,0));
        dist[0]=0;
        ways[0]=1;
        while(!pq.isEmpty()){
            Pair p= pq.poll();
            int node= p.node;
            long time =p.time;
            if(time > dist[node]) continue;

            for(int[] neigh:adj.get(node)){
                int next= neigh[0];
                int t= neigh[1];
                long newTime =time+t;

                if(newTime < dist[next]){
                    dist[next]=newTime;
                    ways[next]=ways[node];
                    pq.add(new Pair(next,newTime));
                }else if(newTime == dist[next]){
                    ways[next]= (ways[next] + ways[node]) % MOD;
                }
            }
        }
        return (int)ways[n-1];
    }
}