class Solution {
    public int removeCoveredIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int ans = 0;
        int end = 0;

        for (int[] i : intervals) {
            if (i[1] > end) {
                ans++;
                end = i[1];
            }
        }

        return ans;
    }
}