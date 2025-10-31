class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        HashMap<Integer,Integer> hm= new HashMap<>();
        for(int num:nums){
            if(hm.containsKey(num)){
                hm.put(num,hm.get(num)+1);
            }else{
                hm.put(num,1);
            }
        
        }
        ArrayList<Integer> res= new ArrayList<>();
        int arr[]=new int[2];
        for(Integer k:hm.keySet()){
            if(hm.get(k)==2){
                res.add(k);
            }
        }
        for(int i=0;i<res.size();i++){
            arr[i]=res.get(i);
        }
        return arr;
    }
}