class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
       int n = arr.length;                   
        Arrays.sort(arr);
        int mod = 1_000_000_007;
        HashMap<Integer, Long> dp = new HashMap<>();  

        long ans = 0;

        for (int i = 0; i < n; i++) {
            dp.put(arr[i], 1L);               

            for (int j = 0; j < n; j++) {
                if (arr[i] % arr[j] == 0) {
                    int right = arr[i] / arr[j];
                    if (dp.containsKey(right)) {   
                        long res = (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(right)) % mod;
                        dp.put(arr[i], res);
                    }
                }
            }

            ans = (ans + dp.get(arr[i])) % mod;
        }

        return (int) ans;

        // int n= arr.length;
        // HashSet<Integer> set= new HashSet<>();
        // HashMap<ArrayList<Integer>, Integer> hm = new HashMap<>();
      

        // for(int i=0;i<n;i++){
        //     set.add(arr[i]);
        // }

        // int count=0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<n;j++){
        //         int pro= arr[i] * arr[j];
        //         ArrayList<Integer> addin= new ArrayList<>();
        //         addin.add(pro);
        //         addin.add(arr[i]);
        //         addin.add(arr[j]);

        //         if(set.contains(pro) && !hm.containsKey(addin)){
        //             count++;
        //         }
        //     }
        // }
        // return count+n;
        
       
    }
}