class Solution {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        ArrayList<Integer> free= new ArrayList<>();
        int n =startTime.length;

        free.add(startTime[0] - 0);
        for(int i=1;i<n;i++){
            free.add( startTime[i] - endTime[i-1] );
        }

        free.add(eventTime- endTime[n-1]); // last free time 
        int windowsize=k+1;
        int i=0;
        int j=0;
        int maxfree=0;
        int curr=0;
        while(j<free.size()){
            curr+= free.get(j);
            while(i<free.size()&& (j-i+1) > windowsize){
                //shrink
                curr-=free.get(i);
                i++;
            }
            maxfree=Math.max(maxfree, curr);
            j++;
        }
        return maxfree;
    }
}