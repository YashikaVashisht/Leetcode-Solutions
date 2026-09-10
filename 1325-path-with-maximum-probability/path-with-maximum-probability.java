class Solution {
    class Pair {
        int node;
        double prob;
        Pair(int node, double prob) {
            this.node = node;
            this.prob = prob;
        }
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<edges.length; i++) {

            int u=edges[i][0];
            int v=edges[i][1];
            double prob=succProb[i];

            adj.get(u).add(new Pair(v, prob));
            adj.get(v).add(new Pair(u, prob));
        }

        double[] dist=new double[n];

        dist[start]=1.0;

       //maxi heap
        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));

        pq.offer(new Pair(start, 1.0));

        while(!pq.isEmpty()) {
            Pair p=pq.poll();
            int node=p.node;
            double prob=p.prob;

            if(node==end) {
                return prob;
            }

            for(Pair neigh:adj.get(node)) {

                double newProb=prob * neigh.prob;
                if(newProb > dist[neigh.node]) {
                    dist[neigh.node]=newProb;
                    pq.offer(new Pair(neigh.node, newProb));
                }
            }
        }

        return 0.0;
    }
}