class Pair {
    String word;
    int cnt;

    Pair(String word, int cnt) {
        this.word = word;
        this.cnt = cnt;
    }
}

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return 0; 
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(beginWord, 1));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            String word = curr.word;
            int count = curr.cnt;

            for (int i = 0; i < word.length(); i++) {
                char[] arr = word.toCharArray();

                for (char c = 'a'; c <= 'z'; c++) {
                    arr[i] = c;
                    String newWord = new String(arr);

                    if (newWord.equals(endWord)) {
                        return count + 1;
                    }

                    if (set.contains(newWord)) {
                        set.remove(newWord);
                        q.offer(new Pair(newWord, count + 1));
                    }
                }
            }
        }
        return 0;
    }
}