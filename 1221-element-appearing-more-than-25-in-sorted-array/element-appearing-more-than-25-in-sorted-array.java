class Solution {
    public int findSpecialInteger(int[] arr) {
        int n= arr.length;
        int freq= n/4;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(arr[i])){
                hm.put(arr[i], hm.get(arr[i]) + 1);
            }else{
                hm.put(arr[i], 1);
            }
        }
        int ans=-1;
        for(int k:hm.keySet()){
            if(hm.get(k)>freq){
                ans=k;
            }
        }
        return ans;
    }
}