class Solution {
    public int brokenCalc(int startValue, int target) {
        if(startValue >= target) {
            return startValue-target;
        }
        // If target is even
        if (target%2==0) {
            return 1 + brokenCalc(startValue, target / 2);
        }

        // If target is odd
        return 1 + brokenCalc(startValue, target + 1);
    }
}