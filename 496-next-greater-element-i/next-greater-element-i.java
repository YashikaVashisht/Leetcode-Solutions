class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s= new Stack<>();
        HashMap<Integer, Integer> hm= new HashMap<>();
        int i=nums2.length-1;
        while(i>=0){
            while(!s.isEmpty() && s.peek()<=nums2[i]){
                s.pop();
            }
            if(s.isEmpty()){
                hm.put(nums2[i],-1);
            }else{
                hm.put(nums2[i], s.peek());
            }
            s.push(nums2[i]);
            i--;
        }

        int[] res= new int[nums1.length];
        for(int j=0;j<nums1.length;j++){
            res[j]= hm.get(nums1[j]);
           }


          return res;
    }
}