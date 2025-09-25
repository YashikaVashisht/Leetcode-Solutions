class Solution {
    public void helper(int[] nums , boolean[] vis,HashSet<List<Integer>> ans, List<Integer> res){
        if(res.size()==nums.length){
            ans.add(new ArrayList<>(res));
            return;
        }

        for(int i=0;i<nums.length; i++){
            if(vis[i]==false){
                vis[i]=true;
                res.add(nums[i]);
                helper(nums, vis, ans, res);
                res.remove(res.size()-1);
                vis[i]=false;
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> ans = new HashSet<>();
        List<Integer> res= new ArrayList<>();
        boolean[] vis = new boolean[n];
        helper(nums, vis, ans , res);
        return new ArrayList<>(ans);
        
    }
}