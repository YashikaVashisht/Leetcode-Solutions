class Solution {
    public boolean canAliceWin(int n) {
        int count=0;
        int remove=10;

        while(n>=remove){
            n-=remove;
            remove--;
            count++;
        }

        return count%2==1;
    }
}