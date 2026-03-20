class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int n= nums.length;
        HashMap<Integer, Integer> mp = new HashMap<>();

        int i=0;
        int j=0;
        int ith=0;

        int result = 0;
        while (j < n) {
            mp.put(nums[j], mp.getOrDefault(nums[j], 0) + 1);

    
            while (mp.size() > k) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                if (mp.get(nums[i]) == 0) {
                    mp.remove(nums[i]);
                }
                i++;
                ith = i;
            }

            while (mp.get(nums[i]) > 1) {
                mp.put(nums[i], mp.get(nums[i]) - 1);
                i++;
            }

            if (mp.size() == k) {
                result += (1 + i - ith);
            }

            j++;
        }

        return result;
    }
}