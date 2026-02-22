class Solution {
    // int result = 0;

    // public void findMAX(char[] arr) {
    //     int i = 0;
    //     int n = arr.length;

    //     while (i < n) {
    //         int length = 1;

    //         if (arr[i] == 'T') {
    //             i++;
    //             while (i < n && arr[i] == 'T') {
    //                 length++;
    //                 i++;
    //             }
    //         } else {
    //             i++;
    //             while (i < n && arr[i] == 'F') {
    //                 length++;
    //                 i++;
    //             }
    //         }

    //         result = Math.max(result, length);
    //     }
    // }

    // public void helper(int i, char[] arr, int k) {
    //     findMAX(arr);

    //     if (i >= arr.length || k == 0) return;

    //     // Flip current character
  //     arr[i] = (arr[i] == 'T') ? 'F' : 'T';
    //     helper(i + 1, arr, k - 1);
    //     // Flip back (backtracking)
    //     arr[i] = (arr[i] == 'T') ? 'F' : 'T';
    //     helper(i + 1, arr, k);
    // }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        // char[] arr = answerKey.toCharArray();
        // helper(0, arr, k);
        // return result;

        //case1 F -> T 
        int n=answerKey.length();
        int res=0;
        int i=0;
        int j=0;
        int countF=0;
        while(j<n){
            if(answerKey.charAt(j)== 'F') countF++;
            while(countF>k){
                //shrink
                if(answerKey.charAt(i) =='F'){
                    countF--;
                    
                }
                i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }

        //case1 T -> F
        i=0;
        j=0;
        int countT=0;
        while(j<n){
            if(answerKey.charAt(j)== 'T') countT++;
            while(countT>k){
                //shrink
                if(answerKey.charAt(i) =='T'){
                    countT--;
                    
                }
                i++;
            }
            res=Math.max(res,j-i+1);
            j++;
        }

        return res;

    }

}