class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;

        // ArrayList<Integer> list= new ArrayList<>();
        // int l=0;
        // int r=k-1;
        // while(r<n) {
        //     int res=Integer.MIN_VALUE;
        //     for (int i = l; i <= r; i++) {
        //         res = Math.max(res, nums[i]);
        //     }
        //     list.add(res);
        //     l++;
        //     r++;
        // }

        // int[] ans = new int[list.size()];
        // for (int i = 0; i < list.size(); i++) {
        //     ans[i] = list.get(i);
        // }
        // return ans;

        int[] ans = new int[n - k + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[0] - a[0]
        );// Max heap
        int l=0;
        int i=0;
        for(int r=0;r<n;r++){
            pq.offer(new int[]{nums[r], r}); //nums[i],i
            if(r-l+1== k){
                while(pq.peek()[1]<l){
                    pq.poll();
                }
                ans[i++]=pq.peek()[0];
                l++;
            }

        }
        return ans;
    }
}