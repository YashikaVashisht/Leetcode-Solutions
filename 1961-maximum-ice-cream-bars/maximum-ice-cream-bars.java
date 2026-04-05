class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        int currprice=0;
        for(int cost:costs){
            if(currprice + cost <= coins){
                currprice+=cost;
                count++;
            }else break;
        }
        return count;
    }
} 