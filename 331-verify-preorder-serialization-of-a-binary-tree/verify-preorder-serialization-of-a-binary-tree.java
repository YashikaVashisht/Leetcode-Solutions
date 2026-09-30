class Solution {
    public boolean isValidSerialization(String preorder) {
        String[] arr=preorder.split(",");

        int slots=1;
        for(int i=0; i < arr.length;i++){

            if(slots == 0){
                return false;
            }
            if(arr[i].equals("#")){
                slots--;
            } else {
                slots++;
            }
        }

        return slots == 0;
    }
}