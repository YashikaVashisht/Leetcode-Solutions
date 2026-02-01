class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int first = nums[0];


        int[] prefixMin = new int[n];
        prefixMin[1] = nums[1];

        for (int i = 2; i < n; i++) {
            prefixMin[i] = Math.min(prefixMin[i - 1], nums[i]);
        }

        int ans = Integer.MAX_VALUE;


        for (int j = 2; j < n; j++) {
            ans = Math.min(ans, first + prefixMin[j - 1] + nums[j]);
        }

        return ans;
    }
}
