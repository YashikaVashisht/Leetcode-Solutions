class Solution {
    public int buttonWithLongestTime(int[][] events) {
        int max= events[0][1];
        int ans= events[0][0];
        int n= events.length;
        for(int i=1;i<n;i++){
            int duration=  events[i][1] - events[i - 1][1];
            if (duration > max || (duration == max && events[i][0] < ans)) {
                max = duration;
                ans = events[i][0];
            }
        }

        return ans;


    }
}