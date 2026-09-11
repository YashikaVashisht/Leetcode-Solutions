class Solution {
    class Triple{
        int i;
        int j;
        int w;
        Triple(int i, int j, int w) {
            this.i=i;
            this.j=j;
            this.w=w;
        }
    }

    
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length;
        int n=heights[0].length;
        int[][] effort = new int[m][n];

        for(int i = 0; i < m; i++){
            Arrays.fill(effort[i], Integer.MAX_VALUE);
        }

        PriorityQueue<Triple> pq =
            new PriorityQueue<>((a, b) -> a.w - b.w);

        effort[0][0] = 0;
        pq.add(new Triple(0, 0, 0));

        int[] di ={-1,1,0,0};
        int[] dj ={0,0,-1,1};
        while(!pq.isEmpty()){
            Triple curr=pq.poll();

            int i=curr.i;
            int j=curr.j;
            int w=curr.w;
            if(i==m-1 && j==n-1) {
                return w;
            }

            for (int k=0;k<4;k++) {

                int ni =i+di[k];
                int nj =j+dj[k];
                if (ni>=0 && ni<m && nj>=0 && nj<n) {

                    int diff = Math.abs(
                        heights[i][j] - heights[ni][nj]
                    );
                    int newEffort=Math.max(w, diff);

                    if (newEffort<effort[ni][nj]) {
                        effort[ni][nj]=newEffort;
                        pq.add(new Triple(ni, nj, newEffort));
                    }
                }
            }
        }
        return 0;


    }
}