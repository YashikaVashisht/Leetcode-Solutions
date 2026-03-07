class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // return countAtMost(nums, goal) - countAtMost(nums, goal - 1);

        int n = nums.length;
        int i = 0;
        int j = 0;
        int currsum = 0;
        int countZero = 0;
        int count = 0;

        while (j < n) {
            currsum += nums[j];

            while (i < j && (nums[i] == 0 || currsum > goal)) {
                if (nums[i] == 0) {
                    countZero++;
                } else {
                    countZero = 0;
                }
                currsum -= nums[i];
                i++;
            }

            if (currsum == goal) {
                count += 1 + countZero;
            }

            j++;
        }

        return count;
    }

    // private int countAtMost(int[] nums, int goal) {
    //     if (goal < 0) return 0;
    //     int l = 0;
    //     int sum = 0;
    //     int count = 0;

    //     for (int r = 0; r < nums.length; r++) {
    //         sum += nums[r];
    //         while (sum > goal) {
    //             sum -= nums[l];
    //             l++;
    //         }
    //         count += (r - l + 1);
    //     }
    //     return count;
    // }
}
