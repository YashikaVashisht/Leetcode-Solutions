class Solution {
    public int splitNum(int num) {
        char[] digits = String.valueOf(num).toCharArray();
        Arrays.sort(digits);

        int num1 = 0, num2 = 0;
        for (int i = 0; i < digits.length; i++) {
            int digit = digits[i] - '0';
            if (i % 2 == 0) {
                num1 = num1 * 10 + digit;
            } else {
                num2 = num2 * 10 + digit;
            }
        }

        return num1 + num2;
    }
}