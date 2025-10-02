class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        // int empty=numBottles;
        // int bottleDrunk= numBottles;
        // numBottles=0;
        // while(numExchange<= empty){
        //     empty=empty-numExchange;
        //     numBottles++;
        //     // numExchange++;
        //     bottleDrunk++;
        //     empty++;
        // }
        // return bottleDrunk;

        int bottleDrunk = 0;
        int empty = 0;

        while (numBottles > 0) {
            
            bottleDrunk += numBottles;
            empty += numBottles;
            numBottles = 0;

           
            if (empty >= numExchange) {
                empty -= numExchange;  
                numBottles = 1;        
                numExchange++;        
            }
        }

        return bottleDrunk;
    }
}