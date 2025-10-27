class Solution {
    public int numberOfBeams(String[] bank) {
        int n= bank.length;
        int m= bank[0].length();
        char[][] mat = new char[n][m];

        for(int i=0;i<n;i++){
            String s= bank[i];
            for(int j=0;j<bank[i].length();j++){
                mat[i][j]= s.charAt(j);
            }
        }

        int prev=0;
        int res=0;

        for(int i=0;i<n;i++){
            int curr=0;
            for(int j=0;j<m;j++){
                if(mat[i][j]=='1') curr++;
            }
            if(curr==0) continue;
            res+= prev*curr;
            prev=curr;
        }
        return res;
    }
}