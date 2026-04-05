class Solution {
    public int maximum69Number (int num) {
        int placeValue=0;
        int placeSix=-1;
        int temp=num;
        while(temp>0){
            int rem= temp%10;
            if(rem==6){
                placeSix=placeValue;
            }
            temp=temp/10;
            placeValue++;

        }

        if(placeSix==-1){// never got 6 in the num
            return num;
        }
        return num +(int)(3*Math.pow(10,placeSix)) ;
    }
}