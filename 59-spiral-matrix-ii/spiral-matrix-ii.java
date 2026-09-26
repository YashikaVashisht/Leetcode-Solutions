class Solution {
    public int[][] generateMatrix(int n) {
       
        int[][] matrix = new int[n][n];

        int start = 0;
        int endRow = n - 1;
        int endCol = n - 1;

        int num=1;
        while (start <= endRow && start <= endCol) {
            //LEFT TO RIGHT
            for (int j = start; j <= endCol; j++) {
                matrix[start][j] = num++; // [0][j]
            }
            // TOP  BOTTOM
            for (int i = start + 1; i <= endRow; i++) {
                matrix[i][endCol]=num++; // [0][j]
            }

            // RIGHT → LEFT
            if (start < endRow) {
                for (int j = endCol - 1; j >= start; j--) {
                   matrix[endRow][j]= num++;
                }

            }

            // BOTTOM → TOP
            if (start < endCol) {
                for (int i = endRow - 1; i > start; i--) {
                    matrix[i][start]=num++;
                }
            }

            start++;
            endRow--;
            endCol--;

        }
        return matrix;
    }
}