class Solution {
    class Pair{
        int node;
        int dist;
        Pair(int node, int dist){
            this.node=node;
            this.dist=dist;
        }
    }

    public int networkDelayTime(int[][] edges, int n, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge:edges){
            int u=edge[0];
            int v=edge[1];
            int dis= edge[2];
            adj.get(u).add(new Pair(v,dis));
            // adj.get(v).add(new Pair(u,dis));
        }
        int[] dist= new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b) -> a.dist - b.dist);

        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair  p= pq.poll();
            int node= p.node;
            int d= p.dist;

            for(Pair neigh: adj.get(node)){
                int newi= d+ neigh.dist;
                if(newi < dist[neigh.node]){
                    dist[neigh.node] = newi;
                    pq.offer(new Pair(neigh.node, newi));
                }
            }
        }  
        int ans=0;
        for(int i=1; i<=n; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;  
    }
}