class Solution {
    class Pair {
        int val;
        int index;

        Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    public int longestSubarray(int[] nums, int limit) {
        PriorityQueue<Pair> minHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        PriorityQueue<Pair> maxHeap =
            new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
        //{val, i}

        int l=0;
        int ans=0;

        for(int r=0;r<nums.length;r++){
            Pair p = new Pair(nums[r], r);
            minHeap.offer(p);
            maxHeap.offer(p);

            while((long)maxHeap.peek().val - minHeap.peek().val > limit){
                l++;

                while(minHeap.peek().index < l) {
                    minHeap.poll();
                }

                while(maxHeap.peek().index < l) {
                    maxHeap.poll();
                }
            } 
            ans = Math.max(ans, r-l+1);
        }
        return ans;


    }
}