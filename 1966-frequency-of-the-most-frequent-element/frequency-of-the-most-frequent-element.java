import java.util.*;

class Solution {

    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;

        long[] prefix = new long[n];
        prefix[0] = nums[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }

        int res = 1;

        for (int i = 0; i < n; i++) {
            int l = 0, r = i;

            while (l <= r) {
                int mid = l + (r - l) / 2;

                int len = i - mid + 1;
                long windowSum = prefix[i] - (mid > 0 ? prefix[mid - 1] : 0);
                long required = (long) nums[i] * len;

                if (required - windowSum <= k) {
                    res = Math.max(res, len);
                    r = mid - 1;   // try expanding left
                } else {
                    l = mid + 1;   // shrink window
                }
            }
        }

        return res;
    }
}