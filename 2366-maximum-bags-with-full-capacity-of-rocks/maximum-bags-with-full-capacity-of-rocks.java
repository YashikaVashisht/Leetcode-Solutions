class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int res=0;
        int n = rocks.length;

        int[] space= new int[n];
        for(int i=0;i<n;i++){
            space[i]= capacity[i]-rocks[i];
        }

        Arrays.sort(space);
        for(int i=0;i<n;i++){
            if(space[i]==0){
                res++;
            }else if(additionalRocks >= space[i]){
                additionalRocks-=space[i];
                res++;
            }else{
                break;
            }
        }
        
        return res;

        // for(int i=0;i<n;i++){
        //     int currbag= capacity[i];
        //     int rock= rocks[i];
        //     int space= currbag- rock;
        //     if(space > 0){ //space in the bag
        //         if(additionalRocks>= space){
        //             rocks[i] = currbag;
        //             additionalRocks -= space;
        //         }
        //     }
        // }

        // for(int i=0;i<n;i++){
        //     if(capacity[i]== rocks[i]){
        //         res++;
        //     }
        // }
        // return res;
    }
}