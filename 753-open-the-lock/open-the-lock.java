class Solution {
    public int openLock(String[] deadends, String target) {
        Queue<String> q= new LinkedList<>();
        Set<String> dead = new HashSet<>();
       
        for (String s : deadends) {
            dead.add(s);
        }

         if(dead.contains("0000")) return -1;
         
        Set<String> vis = new HashSet<>();
        q.offer("0000");
        vis.add("0000");
        int res=0;
        while(!q.isEmpty()){
            int k= q.size();
            for(int l=0;l<k;l++){
                String curr= q.poll();
                if(curr.equals(target)) return res;

                for (int i=0; i<4; i++){
                    char[] arr=curr.toCharArray();
                    if (arr[i]=='9') {
                        arr[i]='0';
                    } else {
                        arr[i]=(char)(arr[i] + 1);
                    }

                    String next = new String(arr);
                    if (!dead.contains(next) && !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }
                     // Restore current character
                    arr = curr.toCharArray();

                    // Move wheel backward
                    arr[i] = (arr[i] == '0') ? '9' : (char)(arr[i] - 1);
                    next = new String(arr);

                    if (!dead.contains(next) && !vis.contains(next)) {
                        vis.add(next);
                        q.offer(next);
                    }    

                }
            }
            res++;
        }
        return -1;


    }
}