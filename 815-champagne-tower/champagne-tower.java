class Solution {
    public double helper(int n, int i, int j, double[][] dp) {
        if(i<0 || j<0) return 0; 
        if(i==0 && j==0) return Math.max(0.0, n-1);
        if(dp[i][j] != -1) return dp[i][j];

        double upleft=  helper(n, i-1,j-1 , dp); 
        double upright=  helper(n, i-1, j, dp) ;  

        // System.out.println(i +" "+ j +" "+ upleft);
        // System.out.println(i+" "+j +" "+upright);
        return dp[i][j]= Math.max(0.0, (upleft/2.0) + (upright/2.0)-1);
        
        
    }
        
    public double champagneTower(int n, int row, int col) {
        if(n==0) return 0;
        if(row==0 && col==0 && n>=1) return 1.0;
        double[][] dp = new double[row+1][col+1];
        for(double[] one:dp){
            Arrays.fill(one, -1.0);
        }
        double l= helper(n ,row-1, col-1, dp);  
        double r= helper(n ,row-1, col, dp);  
        return Math.min(1.0, l/2.0 + r/2.0); //proaobility cant be greater then 1
    
    }
}