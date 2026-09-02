class Solution {
    public void dfs(int node, List<List<Integer>> rooms, boolean[] vis){
        vis[node]= true;
        for(int neigh: rooms.get(node)){
            if(!vis[neigh]){
                dfs(neigh, rooms, vis);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] vis= new boolean[rooms.size()];
        dfs(0, rooms, vis);

   
        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;
    }
}