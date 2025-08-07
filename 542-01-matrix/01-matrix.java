class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int[][] vis= new int[n][m];
        for(int[] it:vis){
            Arrays.fill(it,-1);
        }

        Queue<ArrayList<Integer>> q= new LinkedList<>();
        for(int i=0;i<n; i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=0;
                    ArrayList<Integer> l= new ArrayList<>();
                    l.add(i);
                    l.add(j);
                    q.add(l);
                }
            }
        }

        int[][] direct={{0,-1},{0,1},{1,0},{-1,0}};
        while(!q.isEmpty()){
            ArrayList<Integer> pos= q.poll();
            int i=pos.get(0);
            int j=pos.get(1);
            for(int[] d: direct){
                int newI=i+d[0];
                int newJ=j+d[1];
                if(newI>=0 && newJ>=0 && newI<n && newJ<m ){
                    if(vis[newI][newJ]==-1){
                        vis[newI][newJ]=vis[i][j]+1;
                        
                        ArrayList<Integer> next= new ArrayList<>();
                        next.add(newI);
                        next.add(newJ);
                        q.add(next);
                    }

                } 
            }

        }
        return vis;
    }
}