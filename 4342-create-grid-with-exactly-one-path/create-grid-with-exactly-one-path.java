class Solution {
    public String[] createGrid(int m, int n) {
        char[][] arr= new char[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(arr[i] ,'#');
        }

        if(m==1){
            for(int i=0;i<n;i++){
                arr[0][i]='.';
            }
        }else if(n==1){
            for(int i=0;i<m;i++){
                arr[i][0]='.';
            }
        }else{
            arr[0][0]='.';
            arr[0][1]='.';

            for(int i=0;i<m;i++){
                arr[i][1]='.';
            }

            for(int j=1;j<n;j++){
                arr[m-1][j]='.';
            }
        }
        String[] ans = new String[m];
        for(int i=0;i<m;i++){
            ans[i]= new String(arr[i]);
        }
        return ans;
    }
}