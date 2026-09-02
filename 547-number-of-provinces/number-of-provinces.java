class Solution {
    public void dfs(int node, ArrayList<ArrayList<Integer>> adj,boolean[] vis ){
        vis[node]=true;
        for(int neigh: adj.get(node)){
            if(!vis[neigh]){
                dfs(neigh, adj, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n= isConnected.length;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(isConnected[i][j]==1 && i!=j){
                    adj.get(i).add(j);
                    // adj.get(j).add(i);
                }
            }
        }

        int count=0;
        boolean[] vis = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]==false){
                count++;
                dfs(i, adj, vis);
                
            }
        }
        return count;

    }
}