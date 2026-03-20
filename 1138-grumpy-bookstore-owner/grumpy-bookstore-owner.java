class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n=customers.length;

        int maxUnSatis = 0;
        int currUnSatis = 0;

       
        for (int i = 0; i < minutes; i++) {
            currUnSatis+=customers[i] * grumpy[i];
        }

        maxUnSatis=currUnSatis;

        int i=0;
        int j = minutes;

        while (j < n) {
            // add new element
            currUnSatis+=customers[j] * grumpy[j];

            // remove old element
            currUnSatis-=customers[i] * grumpy[i];

            maxUnSatis=Math.max(maxUnSatis, currUnSatis);

            i++;
            j++;
        }

  
        int totalSat=maxUnSatis;

        for(int k=0;k<n;k++) {
            if (grumpy[k]==0) {
                totalSat+=customers[k];
            }
        }

        return totalSat;
    }
}