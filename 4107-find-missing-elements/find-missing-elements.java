class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> l= new ArrayList<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int num:nums) {
            if (num < min) min=num;
            if (num > max) max=num;
        }

        HashSet<Integer> s = new HashSet<>();
        for(int num:nums) {
            s.add(num);
        }

        for(int i=min;i<=max;i++){
            if(!s.contains(i)){
                l.add(i);
            }
        }

        return l;
    }
}