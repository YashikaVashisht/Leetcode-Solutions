class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (isValid(nums, i, 1)) count++;   // move right
                if (isValid(nums, i, -1)) count++;  // move left
            }
        }
        return count;
    }

    boolean isValid(int[] nums, int start, int dir) {
        int n = nums.length;
        int[] arr = nums.clone();  // copy of nums
        int curr = start;

        while (curr >= 0 && curr < n) {
            if (arr[curr] == 0) {
                curr += dir;
            } else {
                arr[curr]--;
                dir = -dir;        // reverse direction
                curr += dir;
            }
        }

        for (int val : arr) {
            if (val != 0) return false;
        }
        return true;
    }
}
