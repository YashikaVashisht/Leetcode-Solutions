class Solution {
    public int[][] kClosest(int[][] points, int k) {

        TreeMap<Integer, List<int[]>> map = new TreeMap<>();

        // Store distance -> list of points
        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            int dist = x * x + y * y;

            map.putIfAbsent(dist, new ArrayList<>());
            map.get(dist).add(point);
        }

        int[][] ans = new int[k][2];
        int idx = 0;

        // Traverse TreeMap from smallest distance
        for (Map.Entry<Integer, List<int[]>> entry : map.entrySet()) {

            for (int[] point : entry.getValue()) {

                ans[idx++] = point;

                if (idx == k)
                    return ans;
            }
        }

        return ans;
    }
}