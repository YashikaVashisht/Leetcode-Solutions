class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        int res=0;
        //sorting on basis of units descencding
        Arrays.sort(boxTypes, (a, b) -> b[1] - a[1]);
        for(int[] box: boxTypes){
            int n= Math.min(box[0], truckSize);
            res+=n*box[1];
            truckSize-=n;
            if(truckSize<=0) break;
        }
        return res;
    }
}