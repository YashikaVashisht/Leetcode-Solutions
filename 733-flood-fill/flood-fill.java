class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<ArrayList<Integer>> q= new LinkedList<>();
        int n=image.length;
        int m=image[0].length;
        int fill = image[sr][sc];  

        if (fill == color) return image; 

        image[sr][sc] = color; 
        ArrayList<Integer> pos = new ArrayList<>();
        pos.add(sr);
        pos.add(sc);
        q.add(pos);

        
        int[][] direct={{0,1},{0,-1},{1,0}, {-1,0}};
        while(!q.isEmpty()){
            int size=q.size();

            for(int k=0;k<size;k++){
                ArrayList<Integer> curr= q.poll();
                int i=curr.get(0);
                int j=curr.get(1);

                for(int[] d : direct){
                    int newI= i+d[0];
                    int newJ= j+d[1];

                    if(newI >=0 && newJ>=0 && newI<n && newJ<m && image[newI][newJ]==fill){
                        image[newI][newJ]=color;
                        ArrayList<Integer> next= new ArrayList<>();
                        next.add(newI);
                        next.add(newJ);
                        q.add(next);
                    }
                }
            }
        }
        return image;
    }
}