class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        boolean plant= true;
        for(int i=0;i<flowerbed.length; i++){
            if(flowerbed[i]==1) {
                plant=false;
            }else if(plant==true &&
              (i==flowerbed.length-1 || flowerbed[i+1]==0)){
                flowerbed[i]=1;
                n--;
                plant = false;
            }else{
                plant = true;
            }
        }

        return n <= 0;
    }
}