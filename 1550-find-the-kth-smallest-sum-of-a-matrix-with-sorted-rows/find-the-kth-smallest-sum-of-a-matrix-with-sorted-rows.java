class Solution {

    class Node {
        int sum;
        int[] idx;
        Node(int sum, int[] idx) {
            this.sum = sum;
            this.idx = idx;
        }
    }

    public int kthSmallest(int[][] mat, int k) {

        int m = mat.length;
        int n = mat[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        HashSet<String> visited = new HashSet<>();

        int[] start = new int[m];
        int sum = 0;

        for (int i = 0; i < m; i++) {
            sum += mat[i][0];
        }

        pq.offer(new Node(sum, start));
        visited.add(Arrays.toString(start));

        while (k-- > 1) {
            Node curr = pq.poll();

            for (int row = 0; row < m; row++) {

                int[] nextIdx = curr.idx.clone();

                if (nextIdx[row] + 1 < n) {

                    nextIdx[row]++;

                    String key = Arrays.toString(nextIdx);

                    if (!visited.contains(key)) {

                        int newSum = curr.sum
                                - mat[row][curr.idx[row]]
                                + mat[row][nextIdx[row]];

                        pq.offer(new Node(newSum, nextIdx));

                        visited.add(key);
                    }
                }
            }
        }

        return pq.peek().sum;
    }
}