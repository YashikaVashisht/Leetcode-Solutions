class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> res = new ArrayList<>();

        int start = 0;
        int endRow = n - 1;
        int endCol = m - 1;
        while (start <= endRow && start <= endCol) {
            //LEFT TO RIGHT
            for (int j = start; j <= endCol; j++) {
                res.add(matrix[start][j]); // [0][j]
            }
            // TOP  BOTTOM
            for (int i = start + 1; i <= endRow; i++) {
                res.add(matrix[i][endCol]); // [0][j]
            }

            // RIGHT → LEFT
            if (start < endRow) {
                for (int j = endCol - 1; j >= start; j--) {
                    res.add(matrix[endRow][j]);
                }

            }

            // BOTTOM → TOP
            if (start < endCol) {
                for (int i = endRow - 1; i > start; i--) {
                    res.add(matrix[i][start]);
                }
            }

            start++;
            endRow--;
            endCol--;

        }
        return res;
    }

}