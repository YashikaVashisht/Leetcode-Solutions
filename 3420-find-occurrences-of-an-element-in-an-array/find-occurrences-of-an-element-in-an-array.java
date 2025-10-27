class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        ArrayList<Integer> l= new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]==x){
                l.add(i);
            }
        }

        int n=queries.length;

        int[] res= new int[n];
        if (l.size() == 0) {
            Arrays.fill(res, -1);
            return res;
        }


        for(int i=0;i<n;i++){
            int q=queries[i];
            // if(q>maxi){
            //     res[i]=-1;
            // }else{
            //     res[i]=l.get(q-1);
            // }
            if(q<=l.size()){
                res[i]=l.get(q-1);
            }else{
                res[i]=-1;
            }
        }
        return res;
    }
}