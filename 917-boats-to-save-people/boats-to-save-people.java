class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int n = people.length;
        int boats = 0;
        Arrays.sort(people);

        int i = 0;
        int j = n-1;
        while(i<=j){
            if((people[j]+people[i]) <= limit){
                i++;
                j--;
                boats++;
            }else{
                j--;
                boats++;
            }
        }
        return boats;

    }
}