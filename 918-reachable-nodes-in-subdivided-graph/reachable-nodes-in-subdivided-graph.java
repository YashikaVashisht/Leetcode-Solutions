class Solution {
    class Pair{
        int node;
        long dist;
        Pair(int node, long dist){
            this.node=node;
            this.dist=dist;
        }
    }
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            int cnt= edge[2];
            adj.get(u).add(new Pair(v,cnt+1));
            adj.get(v).add(new Pair(u,cnt+1));
        }

        long[] dist= new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair> pq= new PriorityQueue<>(
            (a,b)-> Long.compare(a.dist, b.dist)
        );
        dist[0]=0;
        pq.offer(new Pair(0,0));

        while(!pq.isEmpty()){
            Pair p =pq.poll();
            int node = p.node;
            long d= p.dist;

            if(dist[node]< d) continue; //if dist[node] is already smaller ,no need to change it]


            for(Pair neigh: adj.get(node)){
                int v= neigh.node;
                long distance= neigh.dist;
                if(distance + d < dist[v]){ //if new dist is smaller than the curr 
                    dist[v]= distance + d;
                    pq.offer(new Pair(v, distance+d));
                }
            }
        }
        int res=0;

        for(int i=0; i<n;i++){
            if(dist[i]<= maxMoves){ //if node i is reachable in maxMoves.
                res++;
            }
        }
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            int cnt= edge[2];
            long fromU=0;
            long fromV=0;

            if(dist[u] <= maxMoves){
                fromU=maxMoves-dist[u];
            }

            if(dist[v] <= maxMoves){
                fromV=maxMoves-dist[v];
            }

            res+= Math.min((long)cnt, fromU+fromV);
        }
        return res;
    }
}