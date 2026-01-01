class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int last = digits[n-1];

        if(last != 9){
            digits[n-1] = last + 1;
            return digits;
        }
        digits[n-1] = 0;

        for(int i = n-2; i >= 0; i--){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] res = new int[n+1];
        res[0] = 1;
        return res;
    }
}
