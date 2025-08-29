// class Solution {
//     int timer=0;
//     public void helper(int node, int par,  List<List<Integer>> adj,  boolean[] vis,  ArrayList<ArrayList<Integer>> res,int[] tin, int[] low){
//         vis[node]=true;
//         tin[node]=low[node]=timer;
//         timer++;
//         for(int it: adj.get(node)){
//             if(it==par) continue;
//             if(vis[it]==false){
//                 helper(it,node, adj,vis,res,tin,low);
//                 low[node]=Math.min(low[node], low[it]);
//                 if(low[it]> tin[node]){
//                     res.add(new ArrayList<>(Arrays.asList(it, node)));
//                 }
//                 else {
//                 // Back edge
//                 low[node] = Math.min(low[node], tin[it]);
//             }
//             }
//         }

//     }

//     public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
//         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
//         for(List<Integer> it: connections){
//             int u=it.get(0);
//             int v=it.get(1);
//             adj.get(u).add(v);
//             adj.get(v).add(u);
//         }
//         boolean[] vis= new boolean[n];
//         int[] tin= new int[n];
//         int[] low= new int[n];

//         List<List<Integer>> res = new ArrayList<>();
//         helper(0, -1, adj,vis,res,tin,low);
//         return res;

//     }
// }
import java.util.*;

class Solution {
    int timer = 0;

    public void helper(int node, int par, List<List<Integer>> adj,
                       boolean[] vis, List<List<Integer>> res, int[] tin, int[] low) {
        vis[node] = true;
        tin[node] = low[node] = timer++;
        
        for (int it : adj.get(node)) {
            if (it == par) continue;

            if (!vis[it]) {
                helper(it, node, adj, vis, res, tin, low);
                low[node] = Math.min(low[node], low[it]);

                // check bridge condition
                if (low[it] > tin[node]) {
                    res.add(Arrays.asList(node, it));
                }
            } else {
                // back edge
                low[node] = Math.min(low[node], tin[it]);
            }
        }
    }

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // build graph
        for (List<Integer> it : connections) {
            int u = it.get(0), v = it.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[n];
        int[] tin = new int[n];
        int[] low = new int[n];
        List<List<Integer>> res = new ArrayList<>();

        // run DFS for all components
        for (int i = 0; i < n; i++) {
            if (!vis[i]) helper(i, -1, adj, vis, res, tin, low);
        }

        return res;
    }
}
