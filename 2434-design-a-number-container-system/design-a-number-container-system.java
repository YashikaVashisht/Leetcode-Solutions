import java.util.*;

class NumberContainers {
    HashMap<Integer, Integer> hm;
    // index → number

    HashMap<Integer, TreeSet<Integer>> freq;
    // number → sorted set of indices

    public NumberContainers() {
        hm = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public void change(int index, int number) {
        if (hm.containsKey(index)) {
            int oldNum = hm.get(index); 

            if (freq.containsKey(oldNum)) { // removing the index from set 
                freq.get(oldNum).remove(index);
                if (freq.get(oldNum).isEmpty()) {
                    freq.remove(oldNum);
                }
            }
        }

        hm.put(index, number); 
        freq.putIfAbsent(number, new TreeSet<>());
        freq.get(number).add(index);
    }
    
    public int find(int number) {
        if (freq.containsKey(number) && !freq.get(number).isEmpty()) {
            return freq.get(number).first(); // smallest index
        }
        return -1;
    }
}
