// class Solution {
//     public int orangesRotting(int[][] grid){
//         Queue<ArrayList<Integer>> q= new LinkedList<>();
//         int n=grid.length;
//         int m=grid[0].length;
//         int fresh=0;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<m;j++){
//                 if(grid[i][j]==2){
//                     ArrayList<Integer> pos = new ArrayList<>();
//                     pos.add(i);
//                     pos.add(j);
//                     q.add(pos);
//                 }
//                 if(grid[i][j]==1){
//                     fresh++;
//                 }
//             }
//         }
//         if(fresh==0) return 0;
//         int level=0;

//         int direct[][]= {{-1,0},{0,-1},{0,1},{1,0}};
//         // q.add([-1,-1]);
//         while(!q.isEmpty()){
//             int size=q.size();
//             boolean rot=false;

//             for(int k=0; k<size; k++){
//                 ArrayList<Integer> it=q.poll();
//                 int i= it.get(0);
//                 int j= it.get(1); 
//                 for(int[] d: direct){
//                     int newI= i+d[0];
//                     int newJ= j+d[1];
//                     if(newI>=0 && newJ>=0 && newI<n && newJ<m && grid[newI][newJ]==1 ){//&& grid[newI][newJ]!=2
//                         grid[newI][newJ]=2;
//                         ArrayList<Integer> next= new ArrayList<>();
//                         next.add(newI);
//                         next.add(newJ);
//                         q.add(next);
//                         rot=true;
//                         fresh--;
//                     }
//                 }
//             }
//             if (rot) level++;
             
//         }
//         if(fresh!=0) return -1;
//         else return level;
        
//     }
// }
class Solution {
    public int orangesRotting(int[][] grid){
        Queue<ArrayList<Integer>>  q= new LinkedList<>();
        int fresh=0;
        int n= grid.length;
        int m= grid[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] ==2){
                    ArrayList<Integer> pos= new ArrayList<>();
                    pos.add(i);
                    pos.add(j);
                    q.add(pos);
                }
                if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if(fresh==0) return 0;

        int min=0;
        int[][] direct={{-1,0},{0,-1},{0,1},{1,0}};
        while(!q.isEmpty()){
            int size=q.size();
            boolean rot=false;

            for(int k=0;k<size;k++){
                ArrayList<Integer> top= q.poll();
                int i=top.get(0);
                int j=top.get(1);
                for(int[] d: direct){
                    int newI=i+d[0];
                    int newJ=j+d[1];
                    if(newI>=0 && newJ >=0 && newI<n && newJ<m && grid[newI][newJ]==1){
                        grid[newI][newJ]=2;
                        rot=true;
                        ArrayList<Integer> next= new ArrayList<>();
                        next.add(newI);
                        next.add(newJ);
                        q.add(next);
                        fresh--;

                    }
                }
            }
            if(rot==true) min++;
        }

        if(fresh==0) return min;
        else return -1;
        
    }
}