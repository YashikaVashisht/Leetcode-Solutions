class Solution {

    class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] maxSubsequence(int[] nums, int k) {

        int n = nums.length;

        Pair[] arr = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        // Sort by value descending
        Arrays.sort(arr, (a, b) -> b.val - a.val);

        Pair[] ans = new Pair[k];

        for (int i = 0; i < k; i++) {
            ans[i] = arr[i];
        }

        // Restore original order
        Arrays.sort(ans, (a, b) -> a.idx - b.idx);

        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = ans[i].val;
        }

        return res;
    }
}