class Solution {
    public boolean dfs(int node , ArrayList<ArrayList<Integer>> adj, boolean[] vis, int dest){
        if(node==dest){
            return true;
        }
        vis[node]= true;
        for(int neighbor: adj.get(node)){
            if(!vis[neighbor]){
                if(dfs(neighbor, adj , vis , dest)) return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: edges){
            int u= edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis= new boolean[n];
        return dfs(source, adj, vis, destination);

    }
}