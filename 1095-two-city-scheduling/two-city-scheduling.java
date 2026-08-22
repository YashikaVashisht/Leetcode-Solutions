class Solution {
    public int twoCitySchedCost(int[][] costs) {
        int n= costs.length;
        Arrays.sort(costs, (a,b) ->Integer.compare(a[0]-a[1], b[0]-b[1]) );
        int res=0;
        for(int i=0;i<n/2;i++){
            res+= costs[i][0];
        }

        for(int i=n/2;i<n;i++){
            res+=costs[i][1];
        }

        return res;
    }
}