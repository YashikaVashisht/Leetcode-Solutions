import java.util.*;

class Solution {
    static class Disjointset {
        int rank[];
        int parent[];
        int size[];

        public Disjointset(int n) {
            rank = new int[n];
            Arrays.fill(rank, 0);

            size = new int[n];
            Arrays.fill(size, 1);

            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findParent(int node) {
            if (parent[node] == node) return node;
            return parent[node] = findParent(parent[node]);
        }

        public void unionRANK(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;

            if (rank[pu] < rank[pv]) {
                parent[pu] = pv;
            } else if (rank[pv] < rank[pu]) {
                parent[pv] = pu;
            } else {
                parent[pv] = pu;
                rank[pu]++;
            }
        }

        public void unionSIZE(int u, int v) {
            int pu = findParent(u);
            int pv = findParent(v);
            if (pu == pv) return;

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }
        }
    }

    public int makeConnected(int n, int[][] connections) {
        int totalW = connections.length;
        if (totalW < n - 1) return -1; // Not enough wires to connect all

        Disjointset ds = new Disjointset(n);
        int useless = 0;

        for (int[] it : connections) {
            int u = ds.findParent(it[0]);
            int v = ds.findParent(it[1]);

            if (u == v) {
                useless++; // extra edge
            } else {
                ds.unionSIZE(u, v);
            }
        }

        // Count number of components
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (ds.findParent(i) == i) count++;
        }

        return count - 1; // operations needed
    }
}
