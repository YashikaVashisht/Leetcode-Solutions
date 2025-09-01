class Solution {
    public int[] recoverOrder(int[] order, int[] friends) {
        int n=friends.length;
        int[] res=new int[n]; 
        HashSet<Integer> set=new HashSet<>(); 
        for(int i=0;i<n;i++){
            set.add(friends[i]);
        } 
        ArrayList<Integer> list= new ArrayList<>();
        for(int i=0;i<order.length;i++){
            if(set.contains(order[i])){
                list.add(order[i]);
            }

        }
        for(int i=0;i<n;i++){
            res[i]=list.get(i);
        }
        return res;

    }

}