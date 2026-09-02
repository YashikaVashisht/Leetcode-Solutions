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
        // boolean[] vis= new boolean[rooms.size()];
        // dfs(0, rooms, vis);

   
        // for(int i=0; i<vis.length; i++){
        //     if(!vis[i]){
        //         return false;
        //     }
        // }

        // return true;

        //BFS
        
        Queue<Integer> q= new LinkedList<>();
        boolean[] vis= new boolean[rooms.size()];
        q.add(0);
        vis[0]=true;
        while(!q.isEmpty()){
            int curr= q.poll();
            for(int neigh: rooms.get(curr)){
                if(!vis[neigh]){ //if not visited
                    vis[neigh]=true;
                    q.offer(neigh);
                }
                
            }
        }
        for(int i=0; i<vis.length; i++){
            if(!vis[i]){
                return false;
            }
        }

        return true;

    }
}