class Solution {
    public void bfs(int src, List<List<Integer>> adj, boolean[] vis){
        Queue<Integer> q= new LinkedList<>();
        q.add(src);
        vis[src]=true;
        while(!q.isEmpty()){
            int node= q.poll();
            for(int neigh:adj.get(node)){
                if(vis[neigh]==false){
                    vis[neigh]=true;
                    q.add(neigh);
                }
            }
        }
    }

    public int removeStones(int[][] stones) {
        int n=stones.length;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<n; i++) {
            for(int j=i+1; j<n;j++) {
                if(stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        boolean[] vis= new boolean[n];
        int compo=0;

        for(int i=0;i<n;i++){
            if(vis[i]==false){
                compo++;
                bfs(i,adj,vis);
            }
        }

        return n-compo;
    }
}