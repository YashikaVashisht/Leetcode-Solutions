class Solution {
    public int helper(int count, int n , int copy){
        if(count==n) return 0;
        if(count>n) return Integer.MAX_VALUE;

        int a = Integer.MAX_VALUE;
        int b= Integer.MAX_VALUE;
        if(copy>0 && copy+count <=n){
            a= helper(copy+count, n , copy);
            if(a != Integer.MAX_VALUE){
                a = 1 + a;
            }
        }
        if(copy < count && count + count <= n){
            b = helper(count + count, n, count);
            if(b != Integer.MAX_VALUE){
                b = 2 +b;
            }
        }
        return Math.min(a, b);
    }
    public int minSteps(int n) {
        return helper(1,n,0);
    }
}