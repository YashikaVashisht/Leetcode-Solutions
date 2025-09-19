class AuthenticationManager {
    HashMap<String, Integer> hm;
    int timeToLive;
    public AuthenticationManager(int timeTo) {
        hm= new HashMap<>();
        timeToLive= timeTo;
    }
    
    public void generate(String tokenId, int currentTime) {
        hm.put(tokenId, currentTime+timeToLive);
        
    }
    
    public void renew(String tokenId, int currentTime) {
        if(hm.containsKey(tokenId)){
            int prev= hm.get(tokenId);
            if(prev> currentTime){
                hm.put(tokenId, currentTime+timeToLive);
            }
        }
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count=0;
        for(String k: hm.keySet()){
            if(hm.get(k) > currentTime){
                count++;
            }
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */