class Solution {
    public int totalMoney(int n) {
        int weeks = n / 7;
        int days = n % 7;
    
        int totalWeeks = 28 * weeks + 7 * (weeks * (weeks - 1)) / 2;
        

        int totalDays = days * (2 * (weeks + 1) + (days - 1)) / 2;
        
        return totalWeeks + totalDays;
    }
}