class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg= new int[n];
        for(int [] edge: prerequisites){
            int u= edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            indeg[v]++; //u->v 
        }
        Queue<Integer> q= new ArrayDeque<>();
        for(int i=0;i<n;i++){
            if(indeg[i]==0){
                q.offer(i);
            }
        }
        int count=0;
        while(!q.isEmpty()){
            int node= q.poll();
            count++;
            for(int neigh: adj.get(node)){
                indeg[neigh]--; //removing the edge
                if(indeg[neigh]==0) q.offer(neigh);
            }
            if(count==n) return true;
        }
        return false;

    }
}