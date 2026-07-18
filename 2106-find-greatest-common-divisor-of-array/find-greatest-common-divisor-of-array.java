class Solution {
    public int gcd(int a, int b) {
        while(b != 0) {
            int temp = b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int maxi = nums[0];
        int mini = nums[0];

        for (int num : nums) {
            maxi = Math.max(maxi, num);
            mini = Math.min(mini, num);
        }

        return gcd(maxi, mini);
    }

    
}