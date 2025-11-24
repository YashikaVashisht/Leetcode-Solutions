class KthLargest {
    List<Integer> l= new ArrayList<>();
    int k;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int num: nums){
            l.add(num);
        }
    }
    
    public int add(int val) {
        l.add(val);
        Collections.sort(l);
        int len=l.size();
        return l.get(len-k);
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */