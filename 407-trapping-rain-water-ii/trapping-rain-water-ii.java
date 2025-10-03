import java.util.*;

class Solution {
    public int trapRainWater(int[][] arr) {
        int n = arr.length;
        int m = arr[0].length;


        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        boolean[][] vis = new boolean[n][m];

      
        for (int i = 0; i < n; i++) {
            pq.add(new int[]{arr[i][0], i, 0});
            pq.add(new int[]{arr[i][m - 1], i, m - 1});
            vis[i][0] = true;
            vis[i][m - 1] = true;
        }

        for (int j = 0; j < m; j++) {
            pq.add(new int[]{arr[0][j], 0, j});
            pq.add(new int[]{arr[n - 1][j], n - 1, j});
            vis[0][j] = true;
            vis[n - 1][j] = true;
        }

        int ans = 0;
        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};

        int maxHeight = Integer.MIN_VALUE;

        while (!pq.isEmpty()) {
            int[] it = pq.poll();
            int h = it[0];
            int r = it[1];
            int c = it[2];

            maxHeight = Math.max(maxHeight, h);

            // Explore neighbors
            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];

                if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc]) {
                    vis[nr][nc] = true;

                   
                    if (arr[nr][nc] < maxHeight) {
                        ans += maxHeight - arr[nr][nc];
                    }

                    pq.add(new int[]{arr[nr][nc], nr, nc});
                }
            }
        }

        return ans;
    }
}
