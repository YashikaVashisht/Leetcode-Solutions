class Solution {
    public boolean canFinish(int V, int[][] prereq) {
 
        int l= prereq.length;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>(V);
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        int[] indeg = new int[V];
        for(int i=0;i<l;i++){
            int u=prereq[i][1] ;
            int v=prereq[i][0] ;
            adj.get(u).add(v);
            indeg[v]++;
        }

       Queue<Integer> q= new ArrayDeque<>();
       int count=0;
        for(int i=0;i<V;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
 
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            for(int it:adj.get(node)){
                indeg[it]--;
                if(indeg[it]==0){
                    q.add(it);
                }
            }
            if(count==V) return true;
        }
        return false;

    }
}