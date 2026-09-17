class Solution {
    class Pair{
        int node;
        int wt;
        Pair(int node, int wt){
            this.node= node;
            this.wt= wt;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();  
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<n;i++){
            for(int j= i+1;j<n;j++){

                int x1= points[i][0];
                int y1= points[i][1];
                int x2= points[j][0];
                int y2= points[j][1];

                int dist= Math.abs(x1-x2) + Math.abs(y1-y2);
                adj.get(i).add(new Pair(j, dist));
                adj.get(j).add(new Pair(i, dist));

            }
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.wt - b.wt);
        pq.offer(new Pair(0,0));
        int sum=0;
        boolean[] vis= new boolean[n];
        while(!pq.isEmpty()){
            Pair p = pq.poll();
            int node = p.node;
            int dis= p.wt;

            if(vis[node]==true) continue;
            vis[node]=true;
            sum+=dis;
            for(Pair neigh: adj.get(node)){
                int v= neigh.node;
                int dist= neigh.wt;
                if(vis[v]==false){
                    pq.offer(new Pair(v,dist));
                }
            }

        }
        return sum;

    }
}